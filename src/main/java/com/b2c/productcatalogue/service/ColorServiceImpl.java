package com.b2c.productcatalogue.service;

import com.b2c.productcatalogue.entity.Color;
import com.b2c.productcatalogue.entity.Product;
import com.b2c.productcatalogue.repository.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ColorServiceImpl implements ColorService{

    private ColorRepository colorRepository;

    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsByColor(Long colorId) {

        Optional<Color> color = colorRepository.findById(colorId);
        if(color.isPresent()){
            return color.get().getProducts();
        }

        return null;
    }
}
