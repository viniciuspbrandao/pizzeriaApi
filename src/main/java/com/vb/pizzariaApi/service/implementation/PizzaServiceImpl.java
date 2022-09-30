package com.vb.pizzariaApi.service.implementation;

import com.vb.pizzariaApi.entity.Pizza;
import com.vb.pizzariaApi.entity.entityDTO.PizzaDTO;
import com.vb.pizzariaApi.repository.PizzaRepository;
import com.vb.pizzariaApi.service.PizzaService;
import com.vb.pizzariaApi.service.exceptions.DataIntegratyViolationException;
import com.vb.pizzariaApi.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Pizza findById(Integer id) {
        Optional<Pizza> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object Not Found."));
    }

    public List<Pizza> findAll() {
        return repository.findAll();
    }

    @Override
    public Pizza create(PizzaDTO obj) {
//        findByEmail(obj);
        return repository.save(mapper.map(obj, Pizza.class));
    }

    @Override
    public Pizza update(PizzaDTO obj) {
//        findByEmail(obj);
        return repository.save(mapper.map(obj, Pizza.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

//    private void findByid(PizzaDTO obj) {
//        Optional<Pizza> user = repository.findById(obj.getId());
//        if (user.isPresent() && !user.get().getId().equals(obj.getId())) {
//            throw new DataIntegratyViolationException("id already registered in the system.");
//        }
//    }
}











