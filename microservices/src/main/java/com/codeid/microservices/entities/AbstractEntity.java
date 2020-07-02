package com.codeid.microservices.entities;

import java.io.Serializable;
import javax.persistence.*;


@MappedSuperclass
@SuppressWarnings("serial")
public abstract class AbstractEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}