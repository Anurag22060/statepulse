package com.statepulse.controller;

import com.statepulse.dto.TransportServiceRequest;
import com.statepulse.service.TransportServiceManager;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.statepulse.entity.TransportService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.statepulse.dto.TransportServiceResponse;

import java.util.List;

@RestController
public class TransportServiceController {

    private final TransportServiceManager transportServiceManager;

    public TransportServiceController(TransportServiceManager transportServiceManager) {
        this.transportServiceManager = transportServiceManager;
    }

    private TransportServiceResponse toResponse(TransportService service) {
        TransportServiceResponse response = new TransportServiceResponse();

        response.setId(service.getId());
        response.setServiceCode(service.getServiceCode());
        response.setName(service.getName());
        response.setType(service.getType());
        response.setStatus(service.getStatus());
        response.setDelayMinutes(service.getDelayMinutes());

        return response;
    }

    @PostMapping("/api/transport-services")
    public TransportServiceResponse createTransportService(
            @Valid @RequestBody TransportServiceRequest request) {

        TransportService transportService = new TransportService();

        transportService.setServiceCode(request.getServiceCode());
        transportService.setName(request.getName());
        transportService.setType(request.getType());
        transportService.setStatus(request.getStatus());
        transportService.setDelayMinutes(request.getDelayMinutes());

        TransportService savedService =
                transportServiceManager.createTransportService(transportService);

        return toResponse(savedService);
    }

    @GetMapping("/api/transport-services")
    public List<TransportServiceResponse> getAllTransportServices() {
        return transportServiceManager.getAllTransportServices()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/api/transport-services/{id}")
    public TransportServiceResponse getTransportServiceById(
            @PathVariable Long id) {

        TransportService service =
                transportServiceManager.getTransportServiceById(id)
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Transport service not found with id " + id));

        return toResponse(service);
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
