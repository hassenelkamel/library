package com.jee.library.model.dto;

import com.jee.library.model.BookGenre;
import com.jee.library.model.BookStatus;

import java.util.Date;

/**
 * Created by Viktoriia_Moiseienko on 4/12/2017.
 */
public class BookDto {

    private Long id;
    private String name;
    private Date publishDate;
    private BookStatus bookStatus;
    private BookGenre bookGenre;
    private Long collectionId;

    public BookDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }
}
