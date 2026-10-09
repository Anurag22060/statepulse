package com.statepulse.service;

import com.statepulse.entity.TransportService;
import com.statepulse.repository.TransportServiceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TransportServiceManager {

    private final TransportServiceRepository transportServiceRepository;

    public TransportServiceManager(TransportServiceRepository transportServiceRepository) {
        this.transportServiceRepository = transportServiceRepository;
    }

    public TransportService createTransportService(TransportService transportService) {
        return transportServiceRepository.save(transportService);

    }

    public List<TransportService> getAllTransportServices() {
        return transportServiceRepository.findAll();
    }

    public Optional<TransportService> getTransportServiceById(Long id) {
        return transportServiceRepository.findById(id);
    }

    public TransportService updateTransportService(
            Long id, TransportService updatedService) {

        TransportService existingService = transportServiceRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Transport service not found with id " + id
                ));

        existingService.setServiceCode(updatedService.getServiceCode());
        existingService.setName(updatedService.getName());
        existingService.setType(updatedService.getType());
        existingService.setStatus(updatedService.getStatus());
        existingService.setDelayMinutes(updatedService.getDelayMinutes());

        return transportServiceRepository.save(existingService);
    }

    public void deleteTransportService(Long id) {
        TransportService existingService = transportServiceRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Transport service not found with id " + id
                ));

        transportServiceRepository.delete(existingService);
    }

}
