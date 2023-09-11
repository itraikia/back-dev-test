package com.mca.demo.controllers;

import com.mca.demo.dtos.HealthCheckResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
public class HealthCheckController {

    private static final Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

    @GetMapping()
    public HealthCheckResponseDTO apiHealthCheck() {
        logger.info("Location : {}", "[HealthCheckController.apiHealthCheck]");
        return new HealthCheckResponseDTO(200, "SUCCESS");
    }

}
