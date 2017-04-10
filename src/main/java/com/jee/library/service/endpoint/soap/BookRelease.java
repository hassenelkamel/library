package com.jee.library.service.endpoint.soap;

import com.jee.library.service.BookService;

import javax.ejb.EJB;
import javax.jws.WebService;

/**
 * Created by Viktoriia_Moiseienko on 4/7/2017.
 */
@WebService
public class BookRelease {

    @EJB
    private BookService bookService;

    public void release(long id) {
        bookService.releaseBook(id);
    }
}
