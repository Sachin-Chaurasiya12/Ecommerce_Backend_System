package com.example.EcommBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EcommBackend.dto.CategoryDTO;
import com.example.EcommBackend.dto.RequestCategory;
import com.example.EcommBackend.model.Category;
import com.example.EcommBackend.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
    private final CategoryService service;

    public CategoryController(CategoryService service){
        this.service = service;
    }
    @GetMapping
    public List<CategoryDTO> getCategories(){
        return service.getCategories();
    }

    @PostMapping
    public Category addCategory(@RequestBody RequestCategory category){
        return service.addCategory(category);
    }
}
