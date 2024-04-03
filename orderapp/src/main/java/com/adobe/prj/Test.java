package com.adobe.prj;

import com.adobe.prj.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) throws Exception{
		Product p = new Product(324, "iphone 13", 67000,100);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p);
		  
		System.out.println(json);
	}
  
}
