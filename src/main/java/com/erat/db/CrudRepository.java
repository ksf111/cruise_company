package com.erat.db;

import java.util.List;

public interface CrudRepository <T, ID> {
    List<T> getAll();
    T getById(ID id);
    boolean deleteById(ID id);
    T updateById(T t, ID id);
    T create(T t);

}
