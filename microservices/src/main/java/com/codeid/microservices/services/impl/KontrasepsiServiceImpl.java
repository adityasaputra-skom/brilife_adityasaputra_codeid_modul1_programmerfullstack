package com.codeid.microservices.services.impl;

import javax.transaction.Transactional;

import com.codeid.microservices.entities.Kontrasepsi;
import com.codeid.microservices.exceptions.EntityNotFoundException;
import com.codeid.microservices.repositories.KontrasepsiRepository;
import com.codeid.microservices.services.KontrasepsiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class KontrasepsiServiceImpl implements KontrasepsiService {

    @Autowired
    private KontrasepsiRepository repository;

    @Override
    public Kontrasepsi save(Kontrasepsi entity) {
        return repository.save(entity);
    }

    @Override
    public Kontrasepsi deleteById(Integer id) {
        Kontrasepsi entity = findById(id);
        repository.delete(entity);

        return entity;
    }

    @Override
    public Kontrasepsi findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException();
        });
    }

    @Override
    public Page<Kontrasepsi> findAll(Kontrasepsi entity, int page, int size, Sort.Direction direction) {
        Sort sort = Sort.Direction.DESC.equals(direction) ? Sort.by("id").descending() : Sort.by("id");
        ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return repository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, sort));
    }

}