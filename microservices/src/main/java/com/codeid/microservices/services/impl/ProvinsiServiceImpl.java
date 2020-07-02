package com.codeid.microservices.services.impl;

import javax.transaction.Transactional;

import com.codeid.microservices.entities.Provinsi;
import com.codeid.microservices.exceptions.EntityNotFoundException;
import com.codeid.microservices.repositories.ProvinsiRepository;
import com.codeid.microservices.services.ProvinsiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ProvinsiServiceImpl implements ProvinsiService {

    @Autowired
    private ProvinsiRepository repository;

    @Override
    public Provinsi save(Provinsi entity) {
        return repository.save(entity);
    }

    @Override
    public Provinsi deleteById(Integer id) {
        Provinsi entity = findById(id);
        repository.delete(entity);

        return entity;
    }

    @Override
    public Provinsi findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException();
        });
    }

    @Override
    public Page<Provinsi> findAll(Provinsi entity, int page, int size, Sort.Direction direction) {
        Sort sort = Sort.Direction.DESC.equals(direction) ? Sort.by("id").descending() : Sort.by("id");
        ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return repository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, sort));
    }

}