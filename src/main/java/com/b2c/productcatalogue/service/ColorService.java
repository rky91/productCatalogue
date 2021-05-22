package com.b2c.productcatalogue.service;

import com.b2c.productcatalogue.entity.Color;
import com.b2c.productcatalogue.entity.Product;

import java.util.List;

public interface ColorService {

    List<Color> getAllColors();
    List<Product> getAllProductsByColor(Long colorId);
}
