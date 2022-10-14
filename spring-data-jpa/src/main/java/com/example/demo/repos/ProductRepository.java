package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {//Integer is type of primary key
	public List<Product> findByProductName(String query);
	public List<Product> findByRatePerUnit(double rate);
	
	@Query(value="From Product where ratePerUnit>=:limit",nativeQuery=false)
	public List<Product> sortByPrice(@Param ("limit")double limit );
}
