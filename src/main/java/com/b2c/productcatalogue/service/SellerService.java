package com.b2c.productcatalogue.service;

import com.b2c.productcatalogue.entity.Product;
import com.b2c.productcatalogue.entity.Seller;

import java.util.List;

public interface SellerService {

    List<Seller> getAllSeller();
    List<Product> getAllProductBySeller(Long sellerId);

}
