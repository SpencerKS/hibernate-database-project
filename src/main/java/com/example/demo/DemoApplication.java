package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(DemoApplication.class, args);
		testCart();
	}

	public static void testCart() throws SQLException {
		Cart cart = new Cart();
		List<Product> productList = Product.listAllProducts();
		List<String> productsNames = new ArrayList<>();
		for (int i = 0; i < productList.size(); i++) {
			cart.addItem(productList.get(i));
			productsNames.add(cart.getProductsInCart().get(i).getName());
		}
		System.out.println("Products In Cart: " + productsNames.toString());
		System.out.println("Total: " + String.valueOf(cart.calculateTotal()));
	}
}
