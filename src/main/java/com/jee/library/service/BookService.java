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
    public Book addBook(Book book) {
        return bookDAO.add(book);
    }

    @WebMethod
    public Book updateBook(Book book) {
        return bookDAO.update(book);
    }

    @WebMethod
    public Book removeBook(long id) {
        return bookDAO.delete(id);
    }

    @WebMethod
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }



}
