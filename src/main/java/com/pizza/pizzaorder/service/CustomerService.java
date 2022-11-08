package com.pizza.pizzaorder.service;

import com.pizza.pizzaorder.model.Customer;
import com.pizza.pizzaorder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void makeCustomer(Customer customer){
        customerRepository.save(customer);
    }

//    public getAllCustomers(){
//
//    }

//    public getCustomerById(){
//
//    }
}
