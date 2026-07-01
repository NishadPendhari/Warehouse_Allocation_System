package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductService {
   @Autowired
	private ProductRepository productrepository;
 
   public Product addProduct(Product product)
   {
	   return productrepository.save(product);
   }
   public List<Product>getProducts()
   {
	   return productrepository.findAll();
   }
   public Product getProduct(Long id)
   {
	   return productrepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
   }
}
