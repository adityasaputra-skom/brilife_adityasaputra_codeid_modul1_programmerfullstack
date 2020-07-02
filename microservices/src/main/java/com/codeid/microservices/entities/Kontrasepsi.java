package com.codeid.microservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "list_kontrasepsi")
@Entity
public class Kontrasepsi{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank(message = "{item.notblank}")
    @Column(name = "nama_kontrasepsi")
    private String name;
    
    public Kontrasepsi(String name) {
        this.name = name;
    }
    
    public Kontrasepsi() {
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

}