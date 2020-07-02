package com.codeid.microservices.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.codeid.microservices.entities.Provinsi;
import com.codeid.microservices.repositories.ProvinsiRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;

public class ProvinsiRepositoryCustomImpl implements ProvinsiRepositoryCustom {

    @Autowired
    private EntityManager eManager;

    @Override
    public List<Provinsi> findByName(String name) {
        CriteriaBuilder critBuild = eManager .getCriteriaBuilder();
        CriteriaQuery<Provinsi> critQry = critBuild.createQuery(Provinsi.class);
        Root<Provinsi> root = critQry.from(Provinsi.class);
        critQry.where(critBuild.like(root.get("name"), "%" + name + "%"));

        return eManager.createQuery(critQry).getResultList();
    }
}