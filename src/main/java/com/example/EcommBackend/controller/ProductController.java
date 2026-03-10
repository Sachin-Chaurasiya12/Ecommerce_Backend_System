package com.example.EcommBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommBackend.dto.ProductDTO;
import com.example.EcommBackend.dto.ProductRequest;
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

}