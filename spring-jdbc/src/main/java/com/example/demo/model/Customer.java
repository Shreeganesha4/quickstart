package com.example.demo.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;


// instead of generating setters and gettrs we are using this annotations from lombok.
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data// getter and setter definition

@Component// Class annotated with this will be registered as bean
public class Customer {
    int customerId;
    String customerName;
    String email;


}

