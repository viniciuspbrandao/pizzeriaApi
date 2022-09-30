package com.vb.pizzariaApi.service;


import com.vb.pizzariaApi.entity.Pizza;
import com.vb.pizzariaApi.entity.entityDTO.PizzaDTO;
import com.vb.pizzariaApi.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PizzaService {


    Pizza findById(Integer id);
    List<Pizza> findAll();
    Pizza create(PizzaDTO obj);
    Pizza update(PizzaDTO obj);
    void delete(Integer id);




//    @Autowired
//    private PizzaRepository pizzaRepository;
//
//    public Pizza save(Pizza pizza){
//        return pizzaRepository.save(pizza);
//    }
//
//    public List<Pizza> pizzaList(){
//        return pizzaRepository.findAll();
//    }
//
//    public Optional<Pizza> findById(Integer id){
//        return pizzaRepository.findById(id);
//    }
//
//    public void deleteById(Integer id){
//        pizzaRepository.deleteById(id);
//    }
}
