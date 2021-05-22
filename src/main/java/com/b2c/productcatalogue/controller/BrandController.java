package com.b2c.productcatalogue.controller;

import com.b2c.productcatalogue.entity.Brand;
import com.b2c.productcatalogue.entity.Product;
import com.b2c.productcatalogue.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandController {

    private BrandService brandService;

    @GetMapping
    public List<Brand> getAllBrands(){
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}/products")
    public CollectionModel<List<Product>> getProductsByBrand(@PathVariable Long id){
        CollectionModel<List<Product>> resource = CollectionModel.of(Collections.singleton(brandService.getProductsByBrand(id)));
        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllBrands());
        resource.add(linkTo.withRel("all-brands"));
        return resource;
    }

}
