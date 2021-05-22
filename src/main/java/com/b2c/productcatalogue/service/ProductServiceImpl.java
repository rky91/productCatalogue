package com.b2c.productcatalogue.service;

import com.b2c.productcatalogue.entity.Product;
import com.b2c.productcatalogue.exception.ProductCatalogueException;
import com.b2c.productcatalogue.repository.ProductRepository;
import com.b2c.productcatalogue.utils.ProductGroupBy;
import com.b2c.productcatalogue.utils.ServiceUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private BrandService brandService;
    private ColorService colorService;
    private SellerService sellerService;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductBySku(String sku) {
        Optional<Product> product = productRepository.findBySku(sku);
        if(product.isPresent()){
            return product.get();
        }
        return null;
    }

    @Override
    public List<Product> findProductsByCriteria(ProductGroupBy groupBy, String value){

        switch (groupBy){
            case BRAND:
                if(ServiceUtils.isNumeric(value))
                    return brandService.getProductsByBrand(Long.valueOf(value));
            case COLOR:
                if(ServiceUtils.isNumeric(value))
                    return colorService.getAllProductsByColor(Long.valueOf(value));
            case SELLER:
                if(ServiceUtils.isNumeric(value))
                    return sellerService.getAllProductBySeller(Long.valueOf(value));
            case SIZE:
                return productRepository.findBySize(value);
            default:
                return null;
        }
    }

    @Override
    public synchronized Product buyProduct(Long id, Integer quantity){

        try{
            Optional<Product> existingProduct = productRepository.findById(id);
            if(existingProduct.isPresent()){
                Thread.sleep(10000);
                Product product = existingProduct.get();
                if(product.getQuantity() == 0){
                    throw new ProductCatalogueException("Product is out of stuck.", "");
                } else if(product.getQuantity() < quantity){
                    throw new ProductCatalogueException("Insufficient products available, Available Product quantity: "+product.getQuantity(), "");
                }
                product.setQuantity(product.getQuantity() - quantity);
                Product updatedProduct = productRepository.save(product);
                return updatedProduct;
            } else{
                throw new ProductCatalogueException("Product is not found.", "404");
            }

        } catch (InterruptedException e) {
            throw new ProductCatalogueException("Internal server error !!!", "500");
        }
    }

    public Map<String, Long> getProductCountOnSeller(){
        return null;
    }


}
