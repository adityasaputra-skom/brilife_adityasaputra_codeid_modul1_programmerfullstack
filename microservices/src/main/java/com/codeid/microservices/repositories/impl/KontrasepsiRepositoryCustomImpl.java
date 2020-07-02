package com.codeid.microservices.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.codeid.microservices.entities.Kontrasepsi;
import com.codeid.microservices.repositories.KontrasepsiRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;

public class KontrasepsiRepositoryCustomImpl implements KontrasepsiRepositoryCustom {

    @Autowired
    private EntityManager eManager;

    @Override
    public List<Kontrasepsi> findByName(String name) {
        CriteriaBuilder critBuild = eManager .getCriteriaBuilder();
        CriteriaQuery<Kontrasepsi> critQry = critBuild.createQuery(Kontrasepsi.class);
        Root<Kontrasepsi> root = critQry.from(Kontrasepsi.class);
        critQry.where(critBuild.like(root.get("name"), "%" + name + "%"));

        return eManager.createQuery(critQry).getResultList();
    }
}