package com.cooltee.dao.orm;

import java.util.List;

/**
 * TODO add distributions about this class
 * Created by Daniel on 2017/2/12.
 */
public interface BaseDAO<T> {

    void save(T t);
    void update(T t);
    void delete(Long id);
    List<T> queryAll();
}
