package com.statepulse.controller;

import com.statepulse.service.TransportServiceManager;
import org.springframework.web.bind.annotation.RestController;
import com.statepulse.entity.TransportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TransportServiceController {

    private final TransportServiceManager transportServiceManager;

    public TransportServiceController(TransportServiceManager transportServiceManager) {
        this.transportServiceManager = transportServiceManager;
    }

    @PostMapping("/api/transport-services")
    public TransportService createTransportService(
            @RequestBody TransportService transportService) {

        return transportServiceManager.createTransportService(transportService);
    }
}
