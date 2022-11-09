package com.pizza.pizzaorder.service;

import com.pizza.pizzaorder.model.Pizza;
import com.pizza.pizzaorder.repository.CustomerRepository;
import com.pizza.pizzaorder.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void createPizza(Long customerId, Pizza pizza){
        customerRepository.findById(customerId).map(customer -> {
            pizza.setCustomer(customer);
            return pizzaRepository.save(pizza);
        });
    }

    public Iterable<Pizza> getAllPizzas(){
        return pizzaRepository.findAll();
    }

    public ResponseEntity<?> getPizzaById(Long pizzaId){
        Pizza pizza = pizzaRepository.findById(pizzaId).orElse(null);
        return new ResponseEntity<>(pizza, HttpStatus.OK);
    }

    public void updatePizza(Long customerId, Pizza pizza){
        customerRepository.findById(customerId).map(customer -> {
            pizza.setCustomer(customer);
            return pizzaRepository.save(pizza);
        });
    }

    public void deletePizzaById(Long pizzaId){
        pizzaRepository.deleteById(pizzaId);
    }
}
