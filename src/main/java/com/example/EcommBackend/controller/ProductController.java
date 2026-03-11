package com.example.EcommBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommBackend.dto.CategoryDTO;
import com.example.EcommBackend.dto.ProductDTO;
import com.example.EcommBackend.dto.ProductRequest;
import com.example.EcommBackend.dto.RequestCategory;
import com.example.EcommBackend.model.Product;
import com.example.EcommBackend.service.ProductService;



@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired 
    private ProductService service;

    @GetMapping()
    public List<ProductDTO> getAllProduct(){
        return service.getProducts();
    }

    @PostMapping()
    public Product addProduct(@RequestBody ProductRequest request){
        return service.addProduct(request);
    }

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable Long id){
        return service.getProductbyid(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return service.deleteproduct(id);
    }
    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id,@RequestBody ProductRequest request){
        return service.updateProduct(id,request);
    }

}