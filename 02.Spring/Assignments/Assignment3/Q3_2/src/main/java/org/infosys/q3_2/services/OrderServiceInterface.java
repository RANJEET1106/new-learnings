package org.infosys.q3_2.services;

import org.infosys.q3_2.beans.Product;
import org.infosys.q3_2.beans.User;

import java.util.List;

public interface OrderServiceInterface {
    public void addOrder(User user, List<Product> products);
}
