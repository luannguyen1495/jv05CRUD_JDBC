package com.ra.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<T,ID> {
    List<T> findALl() throws SQLException;
    Boolean save(T t);
    T findId(ID id);
    Boolean update(T t, ID id);
    void delete(ID id);
}
