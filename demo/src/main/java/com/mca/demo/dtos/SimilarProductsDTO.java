package com.mca.demo.dtos;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class SimilarProductsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private List<ProductDetailDTO> similarProducts;

    public SimilarProductsDTO setSimilarProducts(List<ProductDetailDTO> similarProducts) {
        this.similarProducts = similarProducts;
        return this;
    }
}
