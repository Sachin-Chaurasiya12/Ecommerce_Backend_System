package com.example.EcommBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcommBackend.dto.ProductDTO;
import com.example.EcommBackend.dto.ProductRequest;
import com.example.EcommBackend.model.Product;
import com.example.EcommBackend.repository.ProductRepo;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepo repo;

    public List<ProductDTO> getProducts(){
        List<Product> products = repo.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();

        for(Product product : products){

            ProductDTO dto = new ProductDTO();

            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setDescription(product.getDescription());
            dto.setPrice(product.getPrice());
            dto.setCategory(product.getCatogaryId());
            dto.setCreatedAt(product.getCreatedAt());
            dto.setUpdatedAt(product.getUpdatedAt());

            productDTOs.add(dto);
        
        }
        return productDTOs;
    }
}
