package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringDataJpaApplication.class, args);
		
	/*	Product obj=ctx.getBean(Product.class);
		
		ProductService service=ctx.getBean(ProductService.class);
		
		//System.out.println("One product with following details is added="+service);
		
		service.findAll().forEach(System.out::println);
		service.findByProductName("redmi tv").forEach(System.out::println);
		ctx.close();  */
		
	}
	
	@Bean
	public Product tv() {
		return new Product(102,"redmi tv",24000);
	}

}
