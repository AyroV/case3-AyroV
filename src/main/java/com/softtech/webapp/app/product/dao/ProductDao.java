package com.softtech.webapp.app.product.dao;

import com.softtech.webapp.app.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    Product findByProductNameUpper(String productName);
}
