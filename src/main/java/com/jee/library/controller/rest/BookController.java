package com.jee.library.controller.rest;

import com.jee.library.entity.Book;
import com.jee.library.service.BookService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Viktoriia_Moiseienko on 4/10/2017.
 */
@Path("/book")
@Stateless
public class BookController {

    @EJB
    private BookService bookService;

//    @GET
//    @Path("/{param}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String printMessage(@PathParam("param") String msg) {
//        return msg;
//    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Produces("application/xml")
    @Path("/{id}")
    public Book getBook(@PathParam("id") Long id) {
        return bookService.getBookById(id);
    }
}
