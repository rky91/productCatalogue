package com.b2c.productcatalogue.service;

import com.b2c.productcatalogue.entity.Brand;
import com.b2c.productcatalogue.entity.Product;
import com.b2c.productcatalogue.repository.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class BrandServiceImpl implements BrandService{

    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public List<Product> getProductsByBrand(Long brandId) {
        Optional<Brand> brandOpt = brandRepository.findById(brandId);
        if(brandOpt.isPresent()){
            List<Product> products = brandOpt.get().getProducts();
            log.info("Product by brand : {}", products);
            return products;
        }

        return null;
    }
}
