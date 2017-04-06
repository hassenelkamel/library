package com.jee.library.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Viktoriia_Moiseienko on 4/4/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name="Book.findByName",
                query="SELECT c FROM Book c WHERE c.name = :name"), //TODO like % %
})
@Table(name = "book")
public class Book implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "publish_date")
    private Date publishDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_collection_id")
    private BookCollection bookCollection;

    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinTable(name="book_author",
            joinColumns=
            @JoinColumn(name="book_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="author_id", referencedColumnName="id")
    )
    private List<Autor> authors;

    public Book() {
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishDate=" + publishDate +
                ", genre=" + genre +
                ", bookCollection=" + bookCollection +
                ", authors=" + authors +
                '}';
    }
}