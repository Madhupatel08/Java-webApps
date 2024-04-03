package com.adobe.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adobe.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	@Query("from Product where price >= :l and price <= :h")
	//@Query(name = "select * from products where price >= :l  and price <= :h", nativeQuery = true) // SQL
	List<Product> getByRange(@Param("l") double low, @Param("h") double high);
	
	
	@Modifying
	@Query("update Product set price = :pr where id = :id")
	void updateProduct(@Param("id") int id, @Param("pr") double price);
}