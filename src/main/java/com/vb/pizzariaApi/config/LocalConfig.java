package com.vb.pizzariaApi.config;

import com.vb.pizzariaApi.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private PizzaRepository repository;

}