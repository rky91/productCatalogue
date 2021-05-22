package com.b2c.productcatalogue.repository;

import com.b2c.productcatalogue.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
