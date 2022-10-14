package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping(path="/api/v2/product")
public class Contoller {
	
	@Autowired
	ProductService service;
	
	@GetMapping
	public List<Product> findAllProduct(){
		
		return this.service.findAll();
		
	}
	@GetMapping(path="/{id}")
	public Product findById(@PathVariable("id")int id) {
		
		return this.service.findById(id).orElseThrow(()-> new RuntimeException("Element not found!!"));
		
		
	}
	
	@GetMapping(path="/name/{pName}")
	public List<Product> findAllProduct(@PathVariable("pName")String name){
		
		return this.service.findByProductName(name);
		
	}
	
	@GetMapping(path="/rate/{ratePerUnit}")
	public List<Product> findAllProductByRate(@PathVariable("ratePerUnit")double ratePerUnit) {
		return this.service.findByRatePerUnit(ratePerUnit);
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Product prod) throws URISyntaxException{
		Product addedEntity=this.service.update(prod);
		
		return ResponseEntity.ok("Updated");
	}
/*	@GetMapping(path="/sort/{limit}")
	public List<Product> sortByPrice(@PathVariable("limit")double limit) {
		return this.service.sortByPrice(limit);
	}*/
	//url /sort? limit=200
	@GetMapping(path="/sort")
	public List<Product> sortByPrice(@RequestParam("limit")double limit) {
		return this.service.sortByPrice(limit);
	}
	
	@DeleteMapping(path="/del/{id}")
	public String deleteById(@PathVariable("id")int id) {
		this.service.deleteById(id);
		return "item deleted";
	}
	
	

}
