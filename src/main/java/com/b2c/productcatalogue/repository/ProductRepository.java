package com.b2c.productcatalogue.repository;

import com.b2c.productcatalogue.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);

    Optional<Product> findBySku(String sku);

    List<Product> findBySize(String size);

}
