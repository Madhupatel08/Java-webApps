package com.adobe.prj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Item;
import com.adobe.prj.entity.Order;
import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@Component
public class OrderClient implements CommandLineRunner {

	@Autowired
	private OrderService service;
	
	@Override
	public void run(String... args) throws Exception {
		//newOrder();
		//printOrders();
	}

	private void printOrders() {
		List<Order> orders = service.getOrders(); // EAGER fetch items also
		for(Order o : orders) {
			System.out.println(o.getCustomer().getFirstName() + ", " + o.getTotal() +", " + o.getOrderDate());
//			List<Item> items = o.getItems();
//			for(Item item : items) {
//				System.out.println(item.getProduct().getName() + ", " + item.getQty() + ", " + item.getAmount());
//			}
		}
	}

	private void newOrder() {
		Order order = new Order();
		
		/*
		 Product p1 = new Product();
		 p1.setId(2);
		 
		 Item i1 = new Item();
		 i1.setProduct(p1);
		 i1.setQty(1);
		
		*/
		Item i1 = Item.builder().product(Product.builder().id(1).build()).qty(1).build();
	
		Item i2 = Item.builder().product(Product.builder().id(4).build()).qty(2).build();
		
		order.getItems().add(i1);
		order.getItems().add(i2);
		
		order.setCustomer(Customer.builder().email("harry@adobe.com").build()); // get from login
		service.placeOrder(order);
	}

}