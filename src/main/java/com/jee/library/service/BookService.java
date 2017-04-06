package com.jee.library.service;

import com.jee.library.dao.BookDAO;
import com.jee.library.entity.Book;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Viktoriia_Moiseienko on 4/5/2017.
 */

@WebService
public class BookService {

    @EJB
    private BookDAO bookDAO;

    @WebMethod
    public List<Book> getBookByName(String name) {
        return bookDAO.findByName(name);
    }

    @WebMethod
    public void addBook(Book book) {
        bookDAO.add(book);
    }

    @WebMethod
    public void removeBook(long id) {
        bookDAO.delete(id);
    }

}
