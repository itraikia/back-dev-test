package com.mca.demo.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ProductDetailDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private double price;
    @NotEmpty
    private boolean availability;
}
