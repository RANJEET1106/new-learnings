package org.infosys.q3_2.services;

import org.infosys.q3_2.beans.Category;
import org.infosys.q3_2.beans.Product;
import org.infosys.q3_2.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {
    @Autowired
    ProductRepo productRepo;

    @Override
    public void addProduct(Product product, List<Category> categories) {
        product.setCategories(categories);
        productRepo.save(product);
    }

    @Override
    public Product getProductById(long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}
