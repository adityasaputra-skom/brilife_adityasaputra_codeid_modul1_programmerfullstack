package com.codeid.microservices.services;

import com.codeid.microservices.entities.Kontrasepsi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface KontrasepsiService {
    
    public Kontrasepsi save(Kontrasepsi entity);
    
    public Kontrasepsi deleteById(Integer id);

    public Kontrasepsi findById(Integer id);

    public Page<Kontrasepsi> findAll(Kontrasepsi entity, int page, int size, Sort.Direction direction);
}