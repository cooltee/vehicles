package com.cooltee.dao.orm;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * TODO add distributions about this class
 * Created by Daniel on 2017/2/12.
 */
public class BaseDaoImpl<T extends BaseEntity> extends HibernateDaoSupport implements BaseDao<T> {

    @Override
    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        getHibernateTemplate().update(t);
    }

    @Override
    public void delete(T t) {
        getHibernateTemplate().delete(t);
    }

    @Override
    public List<T> queryAll() {
        return null;
    }
}
