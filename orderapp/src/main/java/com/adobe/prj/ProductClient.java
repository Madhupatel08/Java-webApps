package com.adobe.prj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@Component
@Order(1)
public class ProductClient implements CommandLineRunner {

	@Autowired
	private OrderService service;

	// method gets called as soon as Spring container is created
	@Override
	public void run(String... args) throws Exception {
		//addProduct();
		//getProducts();

		//getByRange();

		//update();
	}

	private void getByRange() {
		List<Product>products = service.byRange(15_000, 1_00_000);
		for(Product p: products) {
			System.out.println(p);
		}
	}
	
	private void update() {
		Product p = service.updateProduct(2, 100);
	}
	private void addProduct() {
		Product p = Product.builder().name("Hp Laptop").price(56000.00).quantity(100).build();
		service.addProduct(p); // INSERT SQL
	}

	private void getProducts() {
		List<Product> products = service.getProducts();
		for (Product p : products) {
			System.out.println(p);
		}
	}

}