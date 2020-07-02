package com.codeid.microservices.repositories;

import java.util.List;

import com.codeid.microservices.entities.Provinsi;

public interface ProvinsiRepositoryCustom {

    public List<Provinsi> findByName(String name);
}