package com.statepulse.repository;

import com.statepulse.entity.TransportService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportServiceRepository
        extends JpaRepository<TransportService, Long> {

}