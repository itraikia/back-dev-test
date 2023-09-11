package com.mca.demo.services;

import com.mca.demo.dtos.ProductDetailDTO;
import com.mca.demo.dtos.SimilarProductsDTO;
import com.mca.demo.exceptions.ProductNotFoundException;
import com.mca.demo.externalClients.MocksApiFeignClient;
import com.mca.demo.helper.MockDTOFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private MocksApiFeignClient mocksApiFeignClient;

    private ProductServiceImpl productService;

    private static final String EXPECTED_NOT_FOUND_MESSAGE = "Product Not found";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(mocksApiFeignClient);
    }

    @Test
    public void testGetSimilarProducts() {
        String productId1 = "1";
        String productId2 = "2";
        String productId3 = "3";
        List<String> mockProductsIds = MockDTOFactory.getSimilarProductsIds();
        ProductDetailDTO product1 = MockDTOFactory.getProduct1();
        ProductDetailDTO product2 = MockDTOFactory.getProduct2();
        ProductDetailDTO product3 = MockDTOFactory.getProduct3();
        SimilarProductsDTO expectedResponse = MockDTOFactory.getSimilarProducts();

        when(mocksApiFeignClient.getSimilarProductsIds(productId1)).thenReturn(mockProductsIds);
        when(mocksApiFeignClient.getProductById(productId1)).thenReturn(product1);
        when(mocksApiFeignClient.getProductById(productId2)).thenReturn(product2);
        when(mocksApiFeignClient.getProductById(productId3)).thenReturn(product3);

        SimilarProductsDTO result = productService.getSimilarProducts(productId1);

        assertNotNull(result);
        assertNotNull(result.getSimilarProducts());
        assertEquals(3, result.getSimilarProducts().size());
        assertEquals(result, expectedResponse);
        verify(mocksApiFeignClient, times(1)).getProductById(productId1);
        verify(mocksApiFeignClient, times(1)).getProductById(productId2);
        verify(mocksApiFeignClient, times(1)).getProductById(productId3);
        verify(mocksApiFeignClient, times(1)).getSimilarProductsIds(productId1);
    }

    @Test
    public void testGetProductById() {
        String productId1 = "1";
        ProductDetailDTO product1 = MockDTOFactory.getProduct1();
        when(mocksApiFeignClient.getProductById(productId1)).thenReturn(product1);

        ProductDetailDTO result = productService.getProductById(productId1);

        assertNotNull(result);
        assertTrue(result.isAvailability());
        assertEquals("1", result.getId());
        assertEquals("product1", result.getName());
        assertEquals(22.5, result.getPrice());

        verify(mocksApiFeignClient, times(1)).getProductById(productId1);
    }

    @Test
    public void testGetSimilarProductsNotFound() {
        String productId1 = "1";
        when(mocksApiFeignClient.getProductById(productId1)).thenThrow(ProductNotFoundException.class);
        Exception exception = assertThrows(ProductNotFoundException.class, () -> {
            productService.getSimilarProducts(productId1);
        });

        String expectedMessage = EXPECTED_NOT_FOUND_MESSAGE;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetProductByIdNotFound() {
        String productId1 = "1";
        when(mocksApiFeignClient.getProductById(productId1)).thenThrow(ProductNotFoundException.class);
        Exception exception = assertThrows(ProductNotFoundException.class, () -> {
            productService.getProductById(productId1);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(EXPECTED_NOT_FOUND_MESSAGE));
    }


}
