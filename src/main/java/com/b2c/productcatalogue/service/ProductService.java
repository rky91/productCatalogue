package com.b2c.productcatalogue.service;

import com.b2c.productcatalogue.entity.Product;
import com.b2c.productcatalogue.utils.ProductGroupBy;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findProductBySku(String sku);
    List<Product> findProductsByCriteria(ProductGroupBy groupBy, String id);
    Product buyProduct(Long id, Integer quantity);
}
