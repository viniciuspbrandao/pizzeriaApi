package com.vb.pizzariaApi.repository;

import com.vb.pizzariaApi.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
//    Optional<Pizza> findById(id);
}
