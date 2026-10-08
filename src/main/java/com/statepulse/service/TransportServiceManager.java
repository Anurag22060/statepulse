package com.statepulse.service;

import com.statepulse.entity.TransportService;
import com.statepulse.repository.TransportServiceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
