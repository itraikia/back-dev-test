package com.mca.demo.externalClients;

import com.mca.demo.dtos.ProductDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "mocks-api", url = "${links.mocks-api-url}")
public interface MocksApiFeignClient {
    @GetMapping("/product/{productId}/similarids")
    List<String> getSimilarProductsIds(@PathVariable String productId);

    @GetMapping("/product/{productId}")
    ProductDetailDTO getProductById(@PathVariable String productId);
}
