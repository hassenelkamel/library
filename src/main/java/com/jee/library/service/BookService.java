package com.jee.library.service;

import com.jee.library.dao.BookCollectionDAO;
import com.jee.library.dao.BookDAO;
import com.jee.library.model.entity.Book;
import com.jee.library.model.entity.BookCollection;
import com.jee.library.model.BookStatus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

/**
 * Created by Viktoriia_Moiseienko on 4/7/2017.
 */
@Stateless
public class BookService {

    @EJB
    private BookDAO bookDAO;

    @EJB
    private BookCollectionDAO bookCollectionDAO;

    @EJB
    private BookService bookService;

    public Book getBookById(Long id) {
        return bookDAO.find(id);
    }

    public List<Book> getBookByName(String name) {
        return bookDAO.findByName(name);
    }

    public Book addBook(Book book) {
        return bookDAO.add(book);
    }

    public Book updateBook(Book book) {
        return bookDAO.update(book);
    }

    public Book removeBook(long id) {
        return bookDAO.delete(id);
    }

    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void releaseBook(long id) {
        Book book = bookDAO.find(id);
        if (book == null) return;

        BookCollection bookCollection = book.getBookCollection();
        if (bookCollection == null) return;

        List<Book> books = bookCollection.getBooks();

        for (Book book1 : books) {
            if (book1.getBookStatus() != BookStatus.RELEASED) {
                book1.setBookStatus(BookStatus.RELEASED);  // this code updates in DB too
            }
        }
    }

}
