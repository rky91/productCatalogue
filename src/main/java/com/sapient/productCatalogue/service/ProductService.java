package com.sapient.productCatalogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.productCatalogue.model.Product;
import com.sapient.productCatalogue.model.Seller;
import com.sapient.productCatalogue.repository.ProductRepository;
import com.sapient.productCatalogue.repository.SellerRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	SellerRepository sellerRepo;
	
	public void saveProduct(Product product) {
		productRepo.save(product);
	}
	
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}
	public List<Product> getProductByBrand(String brand){
		List<Product> result;
		result = productRepo.findByBrand(brand);
		return result;
	}
	
	public List<Product> getProductByColor(String color){
		List<Product> result;
		result = productRepo.findByColor(color);
		return result;
	}
	
	public List<Product> getProductBySize(int size){
		List<Product> result;
		result = productRepo.findBySize(size);
		return result;
	}
	
	public List<Product> getProductBySku(String sku){
		List<Product> result;
		result = productRepo.findBySku(sku);
		return result;
	}
	
	public List<Product> getProductByPrice(Double price){
		List<Product> result;
		result = productRepo.findByPrice(price);
		return result;
	}
	
	public long getProductQuantity(String sellerName, int productId) {
		List<Seller> seller = sellerRepo.findBySellerNameAndProductId(sellerName, productId);
		long count = 0;
		count = seller.stream().map(s->s.getQuantity()).reduce(0,Integer::sum);
		return count;
	}
	
	public long getInventory(int productId) {
		long count = 0;
		
		List<Seller> seller = sellerRepo.findByProductId(productId);
		count = seller.stream().map(s->s.getQuantity()).reduce(0, Integer::sum);
		return count;
	}
}
