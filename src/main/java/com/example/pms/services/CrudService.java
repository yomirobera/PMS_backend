package com.example.pms.services;


import java.util.Collection;

//Generic CRUD
public interface CrudService <T,ID> {
    T findById(ID id);
    Collection<T> findAll();
    T add(T entity);
    T update(T entity);
    void deleteById(ID id);
    boolean exists(ID id);
}
