package com.statepulse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TransportService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceCode;

    private String name;

    @Enumerated(EnumType.STRING)
    private TransportType type;

    @Enumerated(EnumType.STRING)
    private TransportStatus status;

    private Integer delayMinutes;
}