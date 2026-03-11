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

    @GetMapping("/{id}")
    public CategoryDTO getCategories(@PathVariable Long id){
        return service.getCategorybyid(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategories(@PathVariable Long id){
        return service.deleteCategories(id);
    }
    @PutMapping("/{id}")
    public CategoryDTO updateCategories(@PathVariable Long id,@RequestBody RequestCategory request){
        return service.updateCategories(id,request);
    }
}
