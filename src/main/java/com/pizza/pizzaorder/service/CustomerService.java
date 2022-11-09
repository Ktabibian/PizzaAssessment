package com.pizza.pizzaorder.service;

import com.pizza.pizzaorder.model.Customer;
import com.pizza.pizzaorder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void makeCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        Iterable<Customer> allCustomers = customerRepository.findAll();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    public ResponseEntity<?> getCustomerById(Long customerId){
        Customer c = customerRepository.findById(customerId).orElse(null);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    public ResponseEntity<?> updateCustomer(Customer customer, Long customerId){
        Customer c = customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deleteCustomer(Long customerId){
        customerRepository.deleteById(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
