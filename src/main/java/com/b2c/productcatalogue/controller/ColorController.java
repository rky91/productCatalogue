package com.b2c.productcatalogue.controller;

import com.b2c.productcatalogue.entity.Color;
import com.b2c.productcatalogue.entity.Product;
import com.b2c.productcatalogue.service.ColorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/colors")
@AllArgsConstructor
public class ColorController {

    private ColorService colorService;

    @GetMapping
    public List<Color> getAllColors(){
        return colorService.getAllColors();
    }

    @GetMapping("/{id}/products")
    public List<Product> getAllProductsByColor(@PathVariable Long id){
        return colorService.getAllProductsByColor(id);
    }

}
