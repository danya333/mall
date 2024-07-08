package com.example.mall.services;

import com.example.mall.dao.ProductDAO;
import com.example.mall.models.Product;
import com.example.mall.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    // Создание товара
    public Product createProduct(ProductDAO productDAO){
        Product product = new Product();
        product.setName(productDAO.getName());
        product.setPrice(productDAO.getPrice());
        productRepository.save(product);
        return product;
    }

    // Получение списка всех товаров
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findProduct(Long id){
        return this.productRepository.findById(id);
    }

    public void deleteProduct(Long id){
        this.productRepository.deleteById(id);
    }

    public void updateProduct(Long productId, String name, Integer price) {
        Product product = this.productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException());
        product.setName(name);
        product.setPrice(price);
        productRepository.save(product);
    }
}
