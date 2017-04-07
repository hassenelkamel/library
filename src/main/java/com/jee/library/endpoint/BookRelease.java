package com.jee.library.endpoint;

import com.jee.library.srvice.BookService;

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
