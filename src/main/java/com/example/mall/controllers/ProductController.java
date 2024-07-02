package com.example.mall.controllers;

import com.example.mall.dao.ProductDAO;
import com.example.mall.models.Product;
import com.example.mall.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> createProduct(@RequestBody ProductDAO productDAO) {
        productService.createProduct(productDAO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Получение списка всех товров
    @GetMapping(path = "product/all")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
