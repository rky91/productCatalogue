package com.b2c.productcatalogue.repository;

import com.b2c.productcatalogue.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
