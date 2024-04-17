package com.matheusob25.projetoweb.services;

import com.matheusob25.projetoweb.entities.Category;
import com.matheusob25.projetoweb.entities.User;

import com.matheusob25.projetoweb.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
