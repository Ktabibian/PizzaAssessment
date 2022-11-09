package com.pizza.pizzaorder.controller;

import com.pizza.pizzaorder.model.Customer;
import com.pizza.pizzaorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public void makeCustomer(@RequestBody Customer customer){
        customerService.makeCustomer(customer);
    }

    @GetMapping("/customers")
    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        return customerService.getAllCustomers();
    }


    @GetMapping("/customers/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }

    @PutMapping("/customers/{customerId}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId){
        return customerService.updateCustomer(customer, customerId);
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId){
        return customerService.deleteCustomer(customerId);
    }
}
