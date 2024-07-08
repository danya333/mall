package com.example.mall.controllers;

import com.example.mall.dao.ProductDAO;
import com.example.mall.models.Product;
import com.example.mall.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("mall/products")
public class ProductsController {
    private final ProductService productService;

    // Создание товара
    @PostMapping(path = "create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDAO productDAO,
                                              BindingResult bindingResult,
                                              UriComponentsBuilder uriComponentsBuilder)
            throws BindException {
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            Product product = productService.createProduct(productDAO);

            return ResponseEntity
                .created(uriComponentsBuilder
                        .replacePath("/mall/products/{productId}")
                        .build(Map.of("productId", product.getId())))
                .body(product);
        }

    }

    // Получение списка всех товров
    @GetMapping(path = "list")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

}
