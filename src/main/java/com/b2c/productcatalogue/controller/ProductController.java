package com.b2c.productcatalogue.controller;

import com.b2c.productcatalogue.entity.Product;
import com.b2c.productcatalogue.service.ProductService;
import com.b2c.productcatalogue.utils.ProductGroupBy;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;


    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/{sku}")
    public Product getProductBySku(@PathVariable String sku){
        return productService.findProductBySku(sku);
    }

    @GetMapping("/{groupBy}/{value}")
    public List<Product> getProductWithFilter(@PathVariable ProductGroupBy groupBy, @PathVariable String value){
        return productService.findProductsByCriteria(groupBy, value);
    }

    @PutMapping("/buy/{id}/{quantity}")
    public Product buyProduct(@PathVariable Long id, @PathVariable Integer quantity){
        return productService.buyProduct(id, quantity);
    }



}
