package com.adobe.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	private OrderService service;
	
	// GET ==> by default from address bar and hyperlink
	// POST ==> FORM data
	// GET http://localhost:8080/api/products
	
	@GetMapping()
	public List<Product>getProducts(){
		return service.getProducts();
	}
	
	//GET http://localhost:8080/api/products/3
	@GetMapping("/{pid}")
	public Product getProduct(@PathVariable("pid")int id){
		return service.getProduct(id);
	}
	
	//POST http://localhost:8080/api/products/3
	// payload contains new product data
	// @RequestBody--> JSOn/XML data has to be converted to Product
	
	@PostMapping
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}
	
	@PostMapping("/{pid}")
	public Product updateProduct(@PathVariable("pid") int id, @RequestBody Product p) {
		return service.updateProduct(id, p.getPrice());
	}
}
