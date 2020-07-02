package com.codeid.microservices.repositories;


import com.codeid.microservices.entities.Kontrasepsi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KontrasepsiRepository extends JpaRepository<Kontrasepsi, Integer> , KontrasepsiRepositoryCustom{
    
}