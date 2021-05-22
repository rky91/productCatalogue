package com.b2c.productcatalogue.controller;

import com.b2c.productcatalogue.entity.Product;
import com.b2c.productcatalogue.entity.Seller;
import com.b2c.productcatalogue.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sellers")
@AllArgsConstructor
public class SellerController {

    private SellerService sellerService;

    @GetMapping
    public List<Seller> getAllSellers(){
        return sellerService.getAllSeller();
    }

    @GetMapping("/{id}/products")
    public List<Product> getAllProductsBySeller(@PathVariable Long id){
        return sellerService.getAllProductBySeller(id);
    }

}
