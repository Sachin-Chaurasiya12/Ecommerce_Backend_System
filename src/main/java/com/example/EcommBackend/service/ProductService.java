package com.example.EcommBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.EcommBackend.Exceptions.ResourceNotFoundException;
import com.example.EcommBackend.dto.CategoryDTO;
import com.example.EcommBackend.dto.ProductDTO;
import com.example.EcommBackend.dto.ProductRequest;
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

    public List<ProductDTO> getProducts() {
    List<Product> products = repo.findAll();
    
    // 1. Check if the list is empty and throw your custom exception
    if (products.isEmpty()) {
        throw new ResourceNotFoundException("No products found");
    }

    List<ProductDTO> productDTOs = new ArrayList<>();

    for (Product product : products) {
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
    product.setDescription(request.getDescription());

    Category foundCategory = repo2.findById(request.getCategoryId())
        .orElseThrow(() -> new RuntimeException("Category not found with ID: " + request.getCategoryId()));

    product.setCategory(foundCategory); 

    return repo.save(product);
}

    public ProductDTO getProductbyid(Long id) {
         Product cat = repo.findById(id)
                             .orElseThrow(() -> new ResourceNotFoundException("Product Not found"));

         return new ProductDTO(cat.getId(),cat.getName(),cat.getDescription(),cat.getPrice(),
         cat.getCategory(),cat.getCreatedAt(),cat.getUpdatedAt());
    }

    public ResponseEntity<String> deleteproduct(Long id) {
        Product product = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        repo.delete(product);

        return ResponseEntity.ok("Product Deleted successfully");

    }

    public ProductDTO updateProduct(Long id, ProductRequest request) {
        Product existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Category category = repo2.findById(request.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setCategory(category);

        Product updated = repo.save(existing);
        return new ProductDTO(
            updated.getId(),
            updated.getName(),
            updated.getDescription(),
            updated.getPrice(),
            updated.getCategory(),
            updated.getCreatedAt(),
            updated.getUpdatedAt()
        );
    }
}
