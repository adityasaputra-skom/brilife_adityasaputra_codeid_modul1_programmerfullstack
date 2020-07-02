package com.codeid.microservices.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.codeid.microservices.entities.PemakaiKontrasepsi;
import com.codeid.microservices.exceptions.EntityNotFoundException;
import com.codeid.microservices.models.PemakaiKontrasepsiList;
import com.codeid.microservices.repositories.PemakaiRepository;
import com.codeid.microservices.services.PemakaiKontrasepsiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class PemakaiKontrasepsiServiceImpl implements PemakaiKontrasepsiService {

    @Autowired
    private PemakaiRepository repository;

    @Override
    public PemakaiKontrasepsi save(PemakaiKontrasepsi entity) {
        return repository.save(entity);
    }

    @Override
    public PemakaiKontrasepsi deleteById(Integer id) {
        PemakaiKontrasepsi entity = findById(id);
        repository.delete(entity);

        return entity;
    }

    @Override
    public PemakaiKontrasepsi findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException();
        });
    }

    @Override
    public Page<PemakaiKontrasepsi> findAll(PemakaiKontrasepsi entity, int page, int size, Sort.Direction direction) {
        Sort sort = Sort.Direction.DESC.equals(direction) ? Sort.by("id").descending() : Sort.by("id");
        ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return repository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, sort));
    }

    @Override
    public List<PemakaiKontrasepsiList> list() {
        return repository.list();
    }

    
}