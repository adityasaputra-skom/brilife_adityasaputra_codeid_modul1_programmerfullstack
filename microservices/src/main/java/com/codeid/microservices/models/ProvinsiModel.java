package com.codeid.microservices.models;

import javax.validation.constraints.NotBlank;


public class ProvinsiModel {

    private Integer id;

    @NotBlank(message = "{name.notblank}")
    private String name;

    public ProvinsiModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProvinsiModel() {
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