package com.vb.pizzariaApi.service.implementation;

import com.vb.pizzariaApi.entity.Pizza;
import com.vb.pizzariaApi.entity.entityDTO.PizzaDTO;
import com.vb.pizzariaApi.repository.PizzaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PizzaServiceImplTest {

    @InjectMocks
    private PizzaServiceImpl service;

    @Mock
    private PizzaRepository repository;

    @Mock
    private ModelMapper mapper;

    private Pizza pizza;
    private PizzaDTO pizzaDTO;
    private Optional<Pizza> optionalPizza;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startPizza();
    }

    @Test
    void whenFindByIdThenReturnAnPizzaInstance() {
        Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(optionalPizza);

        Pizza response = service.findById(1);

        Assertions.assertEquals(Pizza.class, response.getClass());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startPizza(){
        pizza = new Pizza();
        pizzaDTO = new PizzaDTO();
        optionalPizza = Optional.of(new Pizza());
    }
}