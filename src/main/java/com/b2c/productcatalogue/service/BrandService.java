package com.b2c.productcatalogue.service;

import com.b2c.productcatalogue.entity.Brand;
import com.b2c.productcatalogue.entity.Product;

import java.util.List;
import java.util.Set;

public interface BrandService {

    List<Brand> getAllBrands();
    List<Product> getProductsByBrand(Long brandId);
}
