package com.adobe.prj.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.CustomerDao;
import com.adobe.prj.dao.OrderDao;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Item;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	 private ProductDao productDao;//implementation class created by spring Data Jpa is injected
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrderDao orderDao;

	public List<Order> getOrders() {
		return orderDao.findAll();
	}

	// save order
	// save items ==> Cascade takes Care of this
	// reduce inventory ==> quantity of Product
	// compute total
	// all the above should be atomic

	/*
	 * Client passes data as: Order { "customer": {email: "harry@gmail.com"},
	 * "items" : [ {product:{id:3}, qty: 1}, {product: {id:4}, qty: 3} ] }
	 * 
	 */
	@Transactional
	public String placeOrder(Order order) {
//		log.info("Called place order");
		double total = 0.0;
		List<Item> items = order.getItems();
		for (Item item : items) {
//			log.info("Get product from database based on id");
			Product p = productDao.findById(item.getProduct().getId()).get(); // p has complete info
			if (p.getQuantity() < item.getQty()) {
				throw new IllegalArgumentException("Item " + p.getName() + " not in stock!!!!"); // Rollback
			}
			// product is Dirty, got changed --> ORM sends UPDATE SQL
			p.setQuantity(p.getQuantity() - item.getQty()); // reduce stock --> products table
//			log.info("product updated using DIRTY check...");
			item.setAmount(p.getPrice() * item.getQty()); // tax , discount
			total += item.getAmount();
		}
		order.setTotal(total);
		order.setOrderDate(new Date());
		orderDao.save(order); // saves order, saves items ==> CASCADE, @Transactional --> update products
//		log.info("order placed!!!");
		return "order placed!!!";
	}

	public Customer addCustomer(Customer c) {
		return customerDao.save(c);
	}
	
	public List<Customer> getCustomers() {
		return customerDao.findAll();
	}
	
	public List<Product>getProducts(){
		return productDao.findAll();
	}
	
	public Product getProduct(Product p) {
		return productDao.save(p);
	}
	
	public Product addProduct(Product p) {
		return productDao.save(p);
	}
	
	public Product getProduct(int id) {
		return productDao.findById(id).get();
	}
	
	public List<Product> byRange(double low, double high){
		return productDao.getByRange(low, high);
	}
	
	@Transactional
	public Product updateProduct(int id, double price) {
		productDao.updateProduct(id,  price);
		return this.getProduct(id);
	}
}
