package com.codeid.microservices.services;

import com.codeid.microservices.entities.Provinsi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface ProvinsiService {
    
    public Provinsi save(Provinsi entity);
    
    public Provinsi deleteById(Integer id);

    public Provinsi findById(Integer id);

    public Page<Provinsi> findAll(Provinsi entity, int page, int size, Sort.Direction direction);
}