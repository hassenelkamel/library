package com.jee.library.controller.rest;

import com.jee.library.model.entity.Book;
import com.jee.library.service.BookService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Viktoriia_Moiseienko on 4/10/2017.
 */
@Path("/book")
@Stateless
public class BookController {

    @EJB
    private BookService bookService;

    @GET
    @Path("/{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@PathParam("id") Long id) {
        return bookService.getBookById(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
