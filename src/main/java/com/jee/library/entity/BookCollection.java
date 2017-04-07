package com.jee.library.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Viktoriia_Moiseienko on 4/5/2017.
 */
@Entity
@Table(name = "book_collection")
public class BookCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookCollection", fetch = FetchType.EAGER) //since this collection always small
    private List<Book> books;

    public BookCollection() {
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookCollection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
