package com.revature.eCommerce.beans.services;

import com.revature.eCommerce.beans.repositories.CategoryRepository;
import com.revature.eCommerce.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id){
        return categoryRepository.findById(id);
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }
    public void deleteById(Integer id){
        categoryRepository.deleteById(id);
    }

}
