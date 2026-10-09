package com.statepulse.dto;

import com.statepulse.entity.TransportStatus;
import com.statepulse.entity.TransportType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TransportServiceRequest {

    @NotBlank(message = "Service code is required")
    private String serviceCode;

    @NotBlank(message = "Service name is required")
    private String name;

    @NotNull(message = "Transport type is required")
    private TransportType type;

    @NotNull(message = "Transport status is required")
    private TransportStatus status;

    @NotNull(message = "Delay minutes is required")
    @Min(value = 0, message = "Delay minutes cannot be negative")
    private Integer delayMinutes;

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransportType getType() {
        return type;
    }

    public void setType(TransportType type) {
        this.type = type;
    }

    public TransportStatus getStatus() {
        return status;
    }

    public void setStatus(TransportStatus status) {
        this.status = status;
    }

    public Integer getDelayMinutes() {
        return delayMinutes;
    }

    public void setDelayMinutes(Integer delayMinutes) {
        this.delayMinutes = delayMinutes;
    }
}