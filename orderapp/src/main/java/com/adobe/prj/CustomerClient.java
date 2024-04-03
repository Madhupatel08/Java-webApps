package com.adobe.prj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.adobe.prj.entity.Customer;
import com.adobe.prj.service.OrderService;

@Component
@Order(2)
public class CustomerClient implements CommandLineRunner {

	
	@Autowired
	private OrderService service;
	
	@Override
	public void run(String... args) throws Exception {
		//addCustomer();
//		getCustomers();
	}

	private void getCustomers() {
		List<Customer> customers = service.getCustomers();
		for(Customer c: customers) {
			System.out.println(c);
		}
	}

	private void addCustomer() {
		Customer c = new Customer("sam@adobe.com", "Samuel", "Paul");
		service.addCustomer(c);
		
		Customer c2 = new Customer("harry@adobe.com", "Harry", "Potter");
		service.addCustomer(c2);
	}
	
	
	
	

}