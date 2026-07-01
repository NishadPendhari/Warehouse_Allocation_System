package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
   @Autowired
   private ProductService productservice;
   
   @PostMapping
   public Product addProduct(@RequestBody Product product)
   {
	   return productservice.addProduct(product);
   }
   @GetMapping
   public List<Product> getProducts()
   {
	   return productservice.getProducts();
   }
}
