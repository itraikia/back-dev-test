package com.mca.demo.helper;

import com.mca.demo.dtos.HealthCheckResponseDTO;
import com.mca.demo.dtos.ProductDetailDTO;
import com.mca.demo.dtos.SimilarProductsDTO;

import java.util.List;

public class MockDTOFactory {

    public static List<String> getSimilarProductsIds() {
        return List.of("1","2","3");
    }

    public static ProductDetailDTO getProduct1() {
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        productDetailDTO.setId("1");
        productDetailDTO.setName("product1");
        productDetailDTO.setAvailability(true);
        productDetailDTO.setPrice(22.5);
        return productDetailDTO;
    }

    public static ProductDetailDTO getProduct2() {
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        productDetailDTO.setId("2");
        productDetailDTO.setName("product2");
        productDetailDTO.setAvailability(true);
        productDetailDTO.setPrice(22.5);
        return productDetailDTO;
    }

    public static ProductDetailDTO getProduct3() {
        ProductDetailDTO productDetailDTO = new ProductDetailDTO();
        productDetailDTO.setId("3");
        productDetailDTO.setName("product3");
        productDetailDTO.setAvailability(false);
        productDetailDTO.setPrice(22.5);
        return productDetailDTO;
    }

    public static SimilarProductsDTO getSimilarProducts() {
        ProductDetailDTO productDetailDTO1 = new ProductDetailDTO();
        ProductDetailDTO productDetailDTO2 = new ProductDetailDTO();
        ProductDetailDTO productDetailDTO3 = new ProductDetailDTO();
        SimilarProductsDTO similarProductsDTO = new SimilarProductsDTO();

        productDetailDTO1.setId("1");
        productDetailDTO1.setName("product1");
        productDetailDTO1.setAvailability(true);
        productDetailDTO1.setPrice(22.5);

        productDetailDTO2.setId("2");
        productDetailDTO2.setName("product2");
        productDetailDTO2.setAvailability(true);
        productDetailDTO2.setPrice(22.5);

        productDetailDTO3.setId("3");
        productDetailDTO3.setName("product3");
        productDetailDTO3.setAvailability(false);
        productDetailDTO3.setPrice(22.5);

        similarProductsDTO.setSimilarProducts(List.of(productDetailDTO1, productDetailDTO2, productDetailDTO3));

        return similarProductsDTO;
    }
}
