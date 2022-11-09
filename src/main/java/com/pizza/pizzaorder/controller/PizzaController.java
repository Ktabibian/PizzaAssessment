package com.pizza.pizzaorder.controller;

import com.pizza.pizzaorder.model.Pizza;
import com.pizza.pizzaorder.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping("/pizzas/{customerId}/pizzas")
    public void createPizza(@PathVariable(value = "customerId") Long customerId, @RequestBody Pizza pizza){
        pizzaService.createPizza(customerId, pizza);
    }

    @GetMapping("/pizzas")
    public Iterable<Pizza> getAllPizzas(){
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/pizzas/{pizzaId}")
    public ResponseEntity<?> getPizzaById(@PathVariable Long pizzaId){
        return pizzaService.getPizzaById(pizzaId);
    }

    @PutMapping("/pizzas/{customerId}/pizzas")
    public void updatePizza(@PathVariable (value = "customerId") Long customerId, @RequestBody Pizza pizza){
        pizzaService.updatePizza(customerId, pizza);
    }

    @DeleteMapping("/pizzas/{pizzaId}")
    public void deletePizzaById(@PathVariable Long pizzaId){
        pizzaService.deletePizzaById(pizzaId);
    }
}
