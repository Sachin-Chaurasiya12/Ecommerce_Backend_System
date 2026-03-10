package com.example.EcommBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EcommBackend.dto.CategoryDTO;
import com.example.EcommBackend.dto.ProductDTO;
import com.example.EcommBackend.dto.RequestCategory;
import com.example.EcommBackend.model.Category;
import com.example.EcommBackend.model.Product;
import com.example.EcommBackend.repository.CategoryRepo;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepo repo;

    public List<CategoryDTO> getCategories(){
        List<Category> category = repo.findAll();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();

        for(Category c : category){

            CategoryDTO dto = new CategoryDTO();

            dto.setId(c.getId());
            dto.setName(c.getName());
            dto.setDescription(c.getDescription());

            categoryDTOs.add(dto);
        
        }
        return categoryDTOs;
    }
    public Category addCategory(RequestCategory category){
        Category cat = new Category();
        cat.setName(category.getName());
        cat.setDescription(category.getDescription());
        return repo.save(cat);
    }
}
