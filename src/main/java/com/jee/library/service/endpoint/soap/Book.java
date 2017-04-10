package com.jee.library.service.endpoint.soap;

import com.jee.library.service.BookService;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by Viktoriia_Moiseienko on 4/5/2017.
 */

@WebService
public class Book {

    @EJB
    private BookService bookService;

    @WebMethod
    public List<com.jee.library.entity.Book> getByName(String name) {
        return bookService.getBookByName(name);
    }

    @WebMethod
    public com.jee.library.entity.Book add(com.jee.library.entity.Book book) {
        return bookService.addBook(book);
    }

    @WebMethod
    public com.jee.library.entity.Book update(com.jee.library.entity.Book book) {
        return bookService.updateBook(book);
    }

    @WebMethod
    public com.jee.library.entity.Book remove(long id) {
        return bookService.removeBook(id);
    }

    @WebMethod
    public List<com.jee.library.entity.Book> getAll() {
        return bookService.getAllBooks();
    }

}
