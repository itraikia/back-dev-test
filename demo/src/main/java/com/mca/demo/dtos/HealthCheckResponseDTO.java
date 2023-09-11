package com.mca.demo.dtos;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class HealthCheckResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private int status;

    private String message;

    public HealthCheckResponseDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
