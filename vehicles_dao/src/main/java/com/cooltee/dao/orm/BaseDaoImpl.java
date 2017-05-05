package com.cooltee.dao.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * base CURD functions implements
 * Created by Daniel on 2017/2/12.
 */
public abstract class BaseDaoImpl<T extends BaseEntity> extends DaoSupport implements BaseDao<T> {


    private HibernateTemplate hibernateTemplate;

    private Class<T> type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public Long save(T t) {
        return (Long) getHibernateTemplate().save(t);
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
    public T findById(Long id) {
        return getHibernateTemplate().get(type, id);
    }

    @Override
    public List<T> findAll() {
        return getHibernateTemplate().loadAll(type);
    }

    @Override
    protected final void checkDaoConfig() throws IllegalArgumentException {
        if(this.hibernateTemplate == null) {
            throw new IllegalArgumentException("\'sessionFactory\' or \'hibernateTemplate\' is required");
        }
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    protected HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    protected Session getSession(){
        return hibernateTemplate.getSessionFactory().getCurrentSession();
    }
}
