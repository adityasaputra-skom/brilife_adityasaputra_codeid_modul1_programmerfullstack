package com.codeid.microservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "list_kontrasepsi")
@Entity
@SuppressWarnings("serial")
public class Kontrasepsi extends AbstractEntity{

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