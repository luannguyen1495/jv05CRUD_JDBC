package com.ra.model.service;

import java.util.List;

public interface IGenericService<T,ID> {
    List<T> findAll();
    Boolean save(T t);
    T findId(ID id);
    Boolean update(T t,ID id);
    void delete(ID id);

}
