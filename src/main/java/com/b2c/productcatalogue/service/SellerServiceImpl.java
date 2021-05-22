package com.b2c.productcatalogue.service;

import com.b2c.productcatalogue.entity.Product;
import com.b2c.productcatalogue.entity.Seller;
import com.b2c.productcatalogue.repository.SellerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SellerServiceImpl implements SellerService{

    private SellerRepository sellerRepository;

    @Override
    public List<Seller> getAllSeller() {
        return sellerRepository.findAll();
    }

    @Override
    public List<Product> getAllProductBySeller(Long sellerId) {
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        if(seller.isPresent()){
            return seller.get().getProducts();
        }
        return null;
    }
}
