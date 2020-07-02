package com.codeid.microservices.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public interface CommonService<T, ID> {
    
    public T save(T entity);

    public T deleteById(ID id);

    public T findById(ID id);

    public Page<T> findAll(T entity, int page, int size, Direction direction);
}