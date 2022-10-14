package com.example.demo.model;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

import org.springframework.stereotype.Component;


// instead of generating setters and gettrs we are using this annotations from lombok.
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data


public class Invoice {
	int invoiceNumber;
	Customer customer;
	LocalDate invoiceDate;
	double price;

}
