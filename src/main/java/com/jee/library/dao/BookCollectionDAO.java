package com.jee.library.dao;

import com.jee.library.model.entity.BookCollection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by Viktoriia_Moiseienko on 4/7/2017.
 */
@Stateless
public class BookCollectionDAO extends BaseDAO<BookCollection> {

    @PersistenceContext(unitName = "BOOK_UNIT", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    public BookCollectionDAO() {
        super(BookCollection.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }



}
