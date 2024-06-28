package com.example.mall.controllers;

import com.example.mall.DAO.ProductDAO;
import com.example.mall.models.Product;
import com.example.mall.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    // Создание товара
    @PostMapping(path = "product/create", consumes = "application/json")
    public String createProduct(@RequestBody ProductDAO productDAO) {
        return productService.createProduct(productDAO);
    }

    // Получение списка всех товров
    @GetMapping(path = "product/all")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
}
