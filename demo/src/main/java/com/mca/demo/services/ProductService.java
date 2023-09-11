package com.mca.demo.services;

import com.mca.demo.dtos.ProductDetailDTO;
import com.mca.demo.dtos.SimilarProductsDTO;

public interface ProductService {
    SimilarProductsDTO getSimilarProducts(String productId);

    ProductDetailDTO getProductById(String productId);
}
