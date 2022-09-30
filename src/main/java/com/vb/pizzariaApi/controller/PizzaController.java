package com.vb.pizzariaApi.controller;

import com.vb.pizzariaApi.entity.entityDTO.PizzaDTO;
import com.vb.pizzariaApi.service.PizzaService;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PizzaService pizzaService;


    @PostMapping
    public ResponseEntity<PizzaDTO> create(@RequestBody PizzaDTO obj) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(pizzaService.create(obj).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<PizzaDTO>> findAll(){
        return ResponseEntity.ok()
                .body(pizzaService.findAll()
                .stream().map(x -> mapper.map(x,PizzaDTO.class)).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PizzaDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(pizzaService.findById(id),PizzaDTO.class));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PizzaDTO> delete(@PathVariable Integer id){
        pizzaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PizzaDTO> update(@PathVariable Integer id,@RequestBody PizzaDTO obj) {
        obj.setId(id);
        return ResponseEntity.ok().body(mapper.map(pizzaService.update(obj), PizzaDTO.class));
    }

}
