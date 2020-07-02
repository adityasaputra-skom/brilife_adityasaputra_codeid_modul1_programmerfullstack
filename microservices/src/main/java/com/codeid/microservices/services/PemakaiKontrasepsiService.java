package com.codeid.microservices.services;

import java.util.List;

import com.codeid.microservices.entities.PemakaiKontrasepsi;
import com.codeid.microservices.models.PemakaiKontrasepsiList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface PemakaiKontrasepsiService {

    public PemakaiKontrasepsi save(PemakaiKontrasepsi entity);
    
    public PemakaiKontrasepsi deleteById(Integer id);

    public PemakaiKontrasepsi findById(Integer id);

    public List<PemakaiKontrasepsiList> list();

    public Page<PemakaiKontrasepsi> findAll(PemakaiKontrasepsi entity, int page, int size, Sort.Direction direction);
}