package com.jee.library.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Viktoriia_Moiseienko on 4/5/2017.
 */
public abstract class BaseDAO<T> {

    private Class<T> entityClass;

    public BaseDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public T add(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    public T update(T entity) {
        getEntityManager().merge(entity);
        return entity;
    }

    public T delete(Long id) {
        T t = find(id);
        if (t != null) {
            getEntityManager().remove(t);
        }
        return t;
    }

    public List<T> findAll() {
        Query q = getEntityManager().createQuery("SELECT e FROM " + entityClass.getName() + " e");
        List<T> list = (List<T>) q.getResultList();
        return list;
    }

    public T find(Long id) {
        return id == null ? null : getEntityManager().find(entityClass, id);
    }

}
