package com.vb.pizzariaApi.service;

import com.vb.pizzariaApi.entity.Pizza;
import com.vb.pizzariaApi.repository.PizzaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Id;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PizzaServiceTest {

    @InjectMocks
    private PizzaService service;

    @Mock
    private PizzaRepository repository;

    @Mock
    private ModelMapper mapper;

    private Pizza pizza;
    private Optional<Pizza> optionalPizza;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
    }

    @Test
    void pizzaList() {
    }

    @Test
    void findPizzaById() {
        Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(optionalPizza);

//        Pizza response = service.findById();
    }

    @Test
    void deleteById() {
    }

    private void startPizza(){
        pizza = new Pizza();
        optionalPizza = Optional.of(new Pizza());
    }
}