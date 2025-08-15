package com.infosys.inventory;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.inventory.beans.Product;
import com.infosys.inventory.service.InventoryService;

@SpringBootApplication
public class Q1Application implements CommandLineRunner {

	@Autowired
	InventoryService inventoryService;

	public static void main(String[] args) {
		SpringApplication.run(Q1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String productName, productDescription, productCatagory;
		Integer productId, productPrice, productStock;
		Product product;
		List<Product> products;

		System.out.println("Enter 1 to add new Product");
		System.out.println("Enter 2 to see product by id");
		System.out.println("Enter 3 to get all product");
		System.out.println("Enter 4 to update product price");
		System.out.println("Enter 5 to update product stock quantity");
		System.out.println("Enter 6 to delete the product");
		System.out.println("Enter 7 to fetch product by catagory");
		System.out.println("Enter 8 to fetch product between price range");
		System.out.println("Enter 9 to fetch products currently in stock");

		int operation = scanner.nextInt();
		scanner.nextLine();
		switch (operation) {
			case 1:
				System.out.println("Enter the Name of product");
				productName = scanner.nextLine();
				System.out.println("Enter Catagory of Product");
				productCatagory = scanner.nextLine();
				System.out.println("Enter product description");
				productDescription = scanner.nextLine();
				System.out.println("Enter the price of product");
				productPrice = scanner.nextInt();
				System.out.println("Enter the stock quantity of product");
				productStock = scanner.nextInt();

				product = new Product(productName, productCatagory, productDescription, productPrice,
						productStock);
				inventoryService.addProduct(product);
				break;

			case 2:
				System.out.println("Enter the product id to search");
				productId = scanner.nextInt();

				Optional<Product> optional = inventoryService.findProductById(productId);
				product = optional.get();
				if (product != null)
					System.out.println(product.toString());
				else
					System.out.println("No product found with given ID");

				break;

			case 3:
				products = inventoryService.findAllProducts();
				products.forEach(product1 -> System.out.println(product1.toString()));
				break;

			case 4:
				System.out.println("Enter the Product ID to update price");
				productId = scanner.nextInt();
				System.out.println("Enter the updated price");
				productPrice = scanner.nextInt();
				inventoryService.updatePrice(productId, productPrice);
				break;

			case 5:
				System.out.println("Enter the Product ID to update stock quantity");
				productId = scanner.nextInt();
				System.out.println("Enter the updated Stock quantity");
				productStock = scanner.nextInt();
				inventoryService.updateStock(productId, productStock);
				break;

			case 6:
				System.out.println("Enter the product ID to delete the product");
				productId=scanner.nextInt();
				inventoryService.deleteProduct(productId);
				break;

			case 7:
				System.out.println("Enter the catagory of Product to fetch");
				productCatagory = scanner.nextLine();
				products = inventoryService.findAllProductsByCategory(productCatagory);
				products.forEach(product1 -> System.out.println(product1.toString()));
				break;

			case 8:
				System.out.println("Enter Lower Price of Product");
				Integer lowestPrice = scanner.nextInt();
				System.out.println("Enter Higher Price of Product");
				Integer highestPrice = scanner.nextInt();
				products = inventoryService.findAllProductPriceBetween(lowestPrice, highestPrice);
				products.forEach(product1 -> System.out.println(product1.toString()));
				break;

			case 9:
				System.out.println("List of products which are currently in stock");
				products = inventoryService.findAllProductsInStock();
				products.forEach(product1 -> System.out.println(product1.toString()));
				break;
		}
		scanner.close();
	}
}
