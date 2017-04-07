package com.jee.library.srvice;

import com.jee.library.dao.BookCollectionDAO;
import com.jee.library.dao.BookDAO;
import com.jee.library.entity.Book;
import com.jee.library.entity.BookCollection;
import com.jee.library.entity.BookStatus;

import javax.annotation.Resource;
import javax.ejb.*;
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

    @Resource
    private EJBContext context;

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


    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void releaseBook(long id) {
        Book book = bookDAO.find(id);
        if (book == null) return;

        BookCollection bookCollection = book.getBookCollection();
        if (bookCollection == null) return;

        List<Book> collectionBooks = bookCollection.getBooks();
//        try {
            for (Book book1 : collectionBooks) {
                if (book1.getBookStatus() != BookStatus.RELEASED) {
                    book1.setBookStatus(BookStatus.RELEASED);
                    bookDAO.add(book);
                    throw new RuntimeException();
                }
            }
//        } catch (TestException e) {
//            context.setRollbackOnly();
//            System.out.println("TestException");
//        }

    }

}
