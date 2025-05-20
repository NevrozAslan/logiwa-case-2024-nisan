package com.logiwa.productapi.repository;

import com.logiwa.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Özel sorgular (filter gibi) buraya yazılabilir
}

