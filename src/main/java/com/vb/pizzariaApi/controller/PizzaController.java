package com.vb.pizzariaApi.controller;

import com.vb.pizzariaApi.entity.Cliente;
import com.vb.pizzariaApi.entity.Pizza;
import com.vb.pizzariaApi.service.PizzaService;
import org.modelmapper.ModelMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pizza save(@RequestBody Pizza pizza){
        return pizzaService.save(pizza);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pizza> pizzaList(){
        return pizzaService.pizzaList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pizza findById(@PathVariable("id") Integer id){
        return pizzaService.findById(id)
                .orElseThrow(() -> new
                        ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found."));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePizz(@PathVariable("id") Integer id){
        pizzaService.findById(id)
                .map(pizza -> {
                    pizzaService.deleteById(pizza.getId());
                    return Void.TYPE;
                }) .orElseThrow(() -> new
                        ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found."));
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePizza(@PathVariable("id") Integer id, @RequestBody Pizza pizza){
        pizzaService.findById(id)
                .map(pizzaBase -> {
                    modelMapper.map(pizza, pizzaBase);
                            pizzaService.save(pizzaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new
                        ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found."));
    }

}
