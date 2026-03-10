package com.example.EcommBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcommBackend.dto.ProductDTO;
import com.example.EcommBackend.dto.ProductRequest;
import com.example.EcommBackend.dto.ResponseDTO;
import com.example.EcommBackend.model.Category;
import com.example.EcommBackend.model.Product;
import com.example.EcommBackend.repository.CategoryRepo;
import com.example.EcommBackend.repository.ProductRepo;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepo repo;

    @Autowired
    private CategoryRepo repo2;

    public List<ProductDTO> getProducts(){
        List<Product> products = repo.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();

        for(Product product : products){

            ProductDTO dto = new ProductDTO();
            
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setDescription(product.getDescription());
            dto.setPrice(product.getPrice());
            dto.setCategory(product.getCategory());
            dto.setCreatedAt(product.getCreatedAt());
            dto.setUpdatedAt(product.getUpdatedAt());

            productDTOs.add(dto);
        
        }
        return productDTOs;
    }

   public Product addProduct(ProductRequest request) {
    Product product = new Product();
    product.setName(request.getName());
    product.setPrice(request.getPrice());
    // Add description if you want it saved!
    product.setDescription(request.getDescription());

    // 1. Fetch the Category Object
    Category foundCategory = repo2.findById(request.getCategoryId())
        .orElseThrow(() -> new RuntimeException("Category not found with ID: " + request.getCategoryId()));

    // 2. Use the setter that matches your Product Entity field
    // It should likely be setCategory, not setCategoryId
    product.setCategory(foundCategory); 

    return repo.save(product);
}
}
