package com.codeid.microservices.repositories;

import com.codeid.microservices.entities.PemakaiKontrasepsi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PemakaiRepository extends JpaRepository<PemakaiKontrasepsi, Integer>, PemakaiRepositoryCustom {
    
}