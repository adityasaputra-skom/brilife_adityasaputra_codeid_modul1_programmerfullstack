package com.codeid.microservices.models;

import javax.validation.constraints.NotBlank;


public class KontrasepsiModel {

    private Integer id;

    @NotBlank(message = "{name.notblank}")
    private String name;

    public KontrasepsiModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public KontrasepsiModel() {
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}