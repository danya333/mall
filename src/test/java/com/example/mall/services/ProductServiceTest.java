package com.example.mall.services;

import com.example.mall.models.Product;
import com.example.mall.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void getAllProducts() {
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setPrice(1000);
        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setPrice(2000);

        Mockito.when(productRepository.findAll()).thenReturn(List.of(product1, product2));
        List<Product> products = productService.getAllProducts();
        assertArrayEquals(products.toArray(), new Product[]{product1, product2});
    }



}
