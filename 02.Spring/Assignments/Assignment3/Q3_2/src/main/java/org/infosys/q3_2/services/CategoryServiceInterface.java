package org.infosys.q3_2.services;

import org.infosys.q3_2.beans.Category;

import java.util.List;

public interface CategoryServiceInterface {
    public void addCategory(Category category);
    public List<Category> getCategories();
    public Category getCategoryById(long id);
}
