package com.codeid.microservices.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.codeid.microservices.models.PemakaiKontrasepsiList;
import com.codeid.microservices.models.PemakaiKontrasepsiModel;
import com.codeid.microservices.repositories.PemakaiRepositoryCustom;

import org.springframework.beans.factory.annotation.Autowired;

public class PemakaiRepositoryCustomImpl implements PemakaiRepositoryCustom {

    @Autowired
    private EntityManager eManager;

    @Override
    public List<PemakaiKontrasepsiList> list() {
        CriteriaBuilder critBuild = eManager.getCriteriaBuilder();
        CriteriaQuery<PemakaiKontrasepsiList> critQry = critBuild.createQuery(PemakaiKontrasepsiList.class);
        Root<PemakaiKontrasepsiModel> root = critQry.from(PemakaiKontrasepsiModel.class);

        critQry.multiselect(root.get("list_provinsi").get("nama_provinsi"), 
                            critBuild.sum(root.get("jumlah_pemakai")),
                            root.get("list_kontrasepsi").get("nama_kontrasepsi"))
                            .groupBy(root.get("list_provinsi"), root.get("list_kontrasepsi"));
        return eManager.createQuery(critQry).getResultList();
    }

}