package com.jee.library.dao;

import com.jee.library.entity.Book;
import org.hibernate.Hibernate;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Viktoriia_Moiseienko on 4/5/2017.
 */
@Stateless
public class BookDAO extends BaseDAO<Book> {

    @PersistenceContext(unitName = "BOOK_UNIT", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    public BookDAO() {
        super(Book.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


    public List<Book> findByName(String name) {
        TypedQuery<Book> query = em.createNamedQuery("Book.findByName", Book.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    //    @Override  //if authors uses lazy fetch
//    public List<Book> findAll() {
//        List<Book> books = super.findAll();
//        for (Book book: books) {
//              Hibernate.initialize(book.getAuthors());
//        }
//        return books;
//    }
}
