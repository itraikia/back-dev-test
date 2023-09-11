package com.mca.demo.controllers;

import com.mca.demo.dtos.SimilarProductsDTO;
import com.mca.demo.externalClients.MocksApiFeignClient;
import com.mca.demo.helper.MockDTOFactory;
import com.mca.demo.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MocksApiFeignClient mocksApiFeignClient;

    @MockBean
    private ProductService productService;

    @Test
    public void testGetSimilarProducts() throws Exception {
        String productId = "1";
        SimilarProductsDTO expectedResponse = MockDTOFactory.getSimilarProducts();

        when(productService.getSimilarProducts(productId)).thenReturn(expectedResponse);

        mvc.perform( MockMvcRequestBuilders
                        .get("/products/{productId}/similar", productId)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.similarProducts").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.similarProducts[*].id").isNotEmpty());
    }
}
