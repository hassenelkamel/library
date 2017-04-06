package com.jee.library.controller;

import com.jee.library.dao.BookDAO;
import com.jee.library.entity.Autor;
import com.jee.library.entity.Book;
import com.jee.library.entity.BookGenre;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Viktoriia_Moiseienko on 4/5/2017.
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @EJB
    private BookDAO bookDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        book.setName("Harry Potter and some stone");
        book.setBookGenre(BookGenre.FANTACY);
        book.setPublishDate(new Date(1111111111L));
        book.setAuthors(new ArrayList<>(Arrays.asList(new Autor("Joan", "Rolling"))));
        bookDAO.add(book);
        List<Book> bookList = bookDAO.findAll();


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "books ---------" + bookList + "</h1>");
    }
}
