package com.statepulse.controller;

import com.statepulse.dto.TransportServiceRequest;
import com.statepulse.service.TransportServiceManager;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.statepulse.entity.TransportService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TransportServiceController {

    private final TransportServiceManager transportServiceManager;

    public TransportServiceController(TransportServiceManager transportServiceManager) {
        this.transportServiceManager = transportServiceManager;
    }

    @PostMapping("/api/transport-services")
    public TransportService createTransportService(
            @Valid @RequestBody TransportServiceRequest request) {

        TransportService transportService = new TransportService();

        transportService.setServiceCode(request.getServiceCode());
        transportService.setName(request.getName());
        transportService.setType(request.getType());
        transportService.setStatus(request.getStatus());
        transportService.setDelayMinutes(request.getDelayMinutes());

        return transportServiceManager.createTransportService(transportService);
    }

    @GetMapping("/api/transport-services")
    public List<TransportService> getAllTransportServices() {
        return transportServiceManager.getAllTransportServices();
    }

    @GetMapping("/api/transport-services/{id}")
    public TransportService getTransportServiceById(@PathVariable Long id) {
        return transportServiceManager.getTransportServiceById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Transport service not found with id " + id
                ));
    }

    @PutMapping("/api/transport-services/{id}")
    public TransportService updateTransportService(
            @PathVariable Long id,
            @RequestBody TransportService updatedService) {

        return transportServiceManager.updateTransportService(id, updatedService);
    }

    @DeleteMapping("/api/transport-services/{id}")
    public void deleteTransportService(@PathVariable Long id) {
        transportServiceManager.deleteTransportService(id);
    }

}
