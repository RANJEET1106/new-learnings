package org.infosys.q3_2.services;

import jakarta.persistence.Entity;
import org.infosys.q3_2.beans.Category;
import org.infosys.q3_2.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryServiceInterface {
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public void addCategory(Category category) {
        categoryRepo.save(category);

    }

    @Override
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryRepo.findById(id).get();
    }
}
