package com.mca.demo.controllers;

import com.mca.demo.dtos.SimilarProductsDTO;
import com.mca.demo.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}/similar")
    public SimilarProductsDTO getSimilarProducts(@PathVariable String productId) {
        logger.info("Location : {} , Payload : {}", "[ProductController.getSimilarProducts]", productId);
        return productService.getSimilarProducts(productId);
    }
}
