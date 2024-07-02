package com.example.mall.services;

import com.example.mall.dao.ProductDAO;
import com.example.mall.models.Product;
import com.example.mall.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // Создание товара
    public void createProduct(ProductDAO productDAO){
        Product product = new Product();
        product.setName(productDAO.getName());
        product.setPrice(productDAO.getPrice());
        productRepository.save(product);
    }

    // Получение списка всех товаров
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
