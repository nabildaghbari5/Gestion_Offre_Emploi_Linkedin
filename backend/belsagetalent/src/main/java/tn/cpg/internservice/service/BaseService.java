package tn.cpg.internservice.service;

import java.util.List;

import tn.cpg.internservice.exception.NotFoundException;


public interface BaseService<T , ID> {
	T create(T dto);
    T update(ID id, T dto) throws NotFoundException;
    T findById(ID id) throws NotFoundException;
    List<T> findAll();
    void delete(ID id) throws NotFoundException;

}
