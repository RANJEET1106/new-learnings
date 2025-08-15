package org.infosys.q3_2;

import org.infosys.q3_2.beans.*;
import org.infosys.q3_2.services.CategoryService;
import org.infosys.q3_2.services.OrderService;
import org.infosys.q3_2.services.ProductService;
import org.infosys.q3_2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Q32Application implements CommandLineRunner {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(Q32Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String username, password, firstName, lastName, email, catagoryName, productName;

        User user;
        Profile profile;
        Category category;
        Product product;
        Order order;

        List<Category> categories;
        List<Product> products;


        boolean flag=true;
        int operation;
        long id,number;
        double price;

        while (flag) {
            System.out.println("Enter 1 to add user with profile");
            System.out.println("Enter 2 to fetch user with profile and orders");
            System.out.println("Enter 3 to add product category");
            System.out.println("Enter 4 to fetch all categories");
            System.out.println("Enter 5 to fetch products by category");
            System.out.println("Enter 6 to add product");
            System.out.println("Enter 7 to fetch product by ID");
            System.out.println("Enter 8 to fetch all products");
            System.out.println("Enter 9 to create order");

            operation=scanner.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Enter user name");
                    username=scanner.next();
                    System.out.println("Enter password");
                    password=scanner.next();
                    user=new User(username,password);

                    System.out.println("Enter first name");
                    firstName=scanner.next();
                    System.out.println("Enter last name");
                    lastName=scanner.next();
                    System.out.println("Enter email");
                    email=scanner.next();
                    profile= new Profile(firstName,lastName,email);

                    userService.addUser(user,profile);
                    System.out.println("User added successfully");
                    break;

                case 2:
                    System.out.println("Enter id of user to find");
                    id=scanner.nextInt();
                    user=userService.getUserById(id);
                    System.out.println(user.toString());
                    break;

                case 3:
                    System.out.println("Enter name of category to add");
                    catagoryName=scanner.next();
                    category=new Category(catagoryName);
                    categoryService.addCategory(category);
                    System.out.println("Category added successfully");
                    break;

                case 4:
                    categories=categoryService.getCategories();
                    categories.forEach(category1 ->  System.out.println(category1.toString()));
                    break;

                case  5:
                    System.out.println("Enter id of category to find the products");
                    id=scanner.nextInt();
                    category=categoryService.getCategoryById(id);
                    System.out.println("Category: " + category.getName());
                    System.out.println("Products in this category:");
                    category.getProducts().forEach(product1 -> System.out.println(product1.getName()));
                    break;

                case 6:
                    System.out.println("Enter name of product");
                    productName=scanner.next();
                    System.out.println("Enter price");
                    price=scanner.nextDouble();
                    product=new Product(productName,price);

                    System.out.println("Enter number of categories");
                    number=scanner.nextInt();
                    categories=new ArrayList<>();
                    for (int i=0;i<number;i++){
                        System.out.println("Enter category id");
                        id=scanner.nextInt();
                        category=categoryService.getCategoryById(id);
                        categories.add(category);
                    }
                    productService.addProduct(product,categories);
                    System.out.println("Product added successfully");
                    break;

                case 7:
                    System.out.println("Enter id of product to search");
                    id=scanner.nextInt();
                    product=productService.getProductById(id);
                    System.out.println(product.toString());
                    break;

                case 8:
                    products=productService.getProducts();
                    products.forEach(product1 ->  System.out.println(product1.toString()));
                    break;

                case 9:

                    System.out.println("Enter id of user");
                    user=userService.getUserById(scanner.nextLong());
                    System.out.println("Enter number of products in order");
                    number=scanner.nextInt();

                    products=new ArrayList<>();
                    for (int i=0;i<number;i++){
                        System.out.println("Enter product id");
                        id=scanner.nextInt();
                        product=productService.getProductById(id);
                        products.add(product);
                    }
                    orderService.addOrder(user,products);
                    System.out.println("Order added successfully");
                    break;

            }
        }
    }
}
