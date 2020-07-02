package com.codeid.microservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "list_provinsi")
@Entity
@SuppressWarnings("serial")
public class Provinsi extends AbstractEntity{

    @NotBlank(message = "{item.notblank}")
    @Column(name = "nama_provinsi")
    private String name;
    
    public Provinsi(String name) {
        this.name = name;
    }
    
    public Provinsi() {
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}