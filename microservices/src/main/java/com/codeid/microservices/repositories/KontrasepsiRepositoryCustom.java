package com.codeid.microservices.repositories;

import java.util.List;

import com.codeid.microservices.entities.Kontrasepsi;

public interface KontrasepsiRepositoryCustom {

    public List<Kontrasepsi> findByName(String name);
}