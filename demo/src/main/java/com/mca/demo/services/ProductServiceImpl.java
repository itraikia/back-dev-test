package com.mca.demo.services;

import com.mca.demo.dtos.ProductDetailDTO;
import com.mca.demo.dtos.SimilarProductsDTO;
import com.mca.demo.exceptions.ProductNotFoundException;
import com.mca.demo.externalClients.MocksApiFeignClient;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final MocksApiFeignClient mocksApiFeignClient;

    public ProductServiceImpl(MocksApiFeignClient mocksApiFeignClient) {
        this.mocksApiFeignClient = mocksApiFeignClient;
    }

    @Override
    @Cacheable(value = "similarProductsCache", key = "#productId")
    public SimilarProductsDTO getSimilarProducts(String productId) {
        try {
            SimilarProductsDTO similarProductsDTO = new SimilarProductsDTO();
            List<String> ids = mocksApiFeignClient.getSimilarProductsIds(productId);
            if (Objects.isNull(ids) || ids.isEmpty()) {
                throw new ProductNotFoundException("Product Not found");
            }
            List<ProductDetailDTO> productDetailDTOList = ids
                    .stream()
                    .map(this::getProductById)
                    .collect(Collectors.toList());
            return similarProductsDTO.setSimilarProducts(productDetailDTOList);
        } catch (Exception e) {
            logger.error("Exception occurred in ProductServiceImpl.getSimilarProducts, details : {}", e.getMessage());
            throw new ProductNotFoundException("Product Not found");
        }
    }

    @Override
    @Cacheable(value = "getProductCache", key = "#productId")
    public ProductDetailDTO getProductById(String productId) {
        try {
            ProductDetailDTO productDetailDTO = mocksApiFeignClient.getProductById(productId);
            if (Objects.isNull(productDetailDTO)) {
                throw new ProductNotFoundException("Product Not found");
            }
            return productDetailDTO;
        } catch (Exception e) {
            logger.error("Exception occurred in ProductServiceImpl.getProductById, details : {}", e.getMessage());
            throw new ProductNotFoundException("Product Not found");
        }
    }
}
