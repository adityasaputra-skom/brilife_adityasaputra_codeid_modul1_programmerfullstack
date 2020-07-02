package com.codeid.microservices.repositories;


import com.codeid.microservices.entities.Provinsi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinsiRepository extends JpaRepository<Provinsi, Integer> , ProvinsiRepositoryCustom{
    
}