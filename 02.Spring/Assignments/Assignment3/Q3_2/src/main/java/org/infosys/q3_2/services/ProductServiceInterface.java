package org.infosys.q3_2.services;

import org.infosys.q3_2.beans.Category;
import org.infosys.q3_2.beans.Product;

import java.util.List;

public interface ProductServiceInterface {
    public void addProduct(Product product, List<Category> categories);
    public Product getProductById(long id);
    public List<Product> getProducts();
}
