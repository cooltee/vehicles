package com.cooltee.dao.orm;

import java.io.Serializable;
import java.util.List;

/**
 * TODO add distributions about this class
 * Created by Daniel on 2017/2/12.
 */
public interface BaseDao<T extends BaseEntity> {

    /**
     * Base save method:save entity instance to db
     * @param t the instance of entity
     */
    void save(T t);

    /**
     * Base update method:update entity instance to db
     * @param t the instance of entity
     */
    void update(T t);

    /**
     * Base delete method:delete entity instance to db
     * @param t the instance of entity
     */
    void delete(T t);

    /**
     * Base query all entity as list from db
     * @return list of instances of entity
     */
    List<T> queryAll();

}
