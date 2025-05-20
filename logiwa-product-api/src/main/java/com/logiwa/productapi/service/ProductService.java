package com.logiwa.productapi.service;

import com.logiwa.productapi.exception.CategoryNotFoundException;
import com.logiwa.productapi.model.Category;
import com.logiwa.productapi.model.Product;
import com.logiwa.productapi.repository.CategoryRepository;
import com.logiwa.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product createProduct(Product product) {
        if (product.getTitle() == null || product.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Başlık boş olamaz.");
        }

        Category category = product.getCategory();
        if (category == null || category.getId() == null) {
            throw new IllegalArgumentException("Ürünün bir kategorisi olmalı.");
        }

        Optional<Category> categoryFromDb = categoryRepository.findById(category.getId());
        if (categoryFromDb.isEmpty()) {
            throw new CategoryNotFoundException("Kategori bulunamadı.");
        }

        int minStock = categoryFromDb.get().getMinStock();
        boolean isLive = product.getStockQuantity() >= minStock;
        product.setLive(isLive);

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
