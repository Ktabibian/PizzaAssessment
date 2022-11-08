package com.pizza.pizzaorder.controller;

import com.pizza.pizzaorder.model.Customer;
import com.pizza.pizzaorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public void makeCustomer(@RequestBody Customer customer){
        customerService.makeCustomer(customer);
    }

    //@GetMapping("/customers")


    //@GetMapping("customers/{id}")
}
