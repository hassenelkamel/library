package com.jee.library.entity;

import com.jee.library.util.JaxbDateSerializer;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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
   @XmlElement(required = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "publish_date")
    private Date publishDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "bookGenre")
    private BookGenre bookGenre;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookStatus bookStatus;

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

    @XmlJavaTypeAdapter(JaxbDateSerializer.class)
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
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
                ", bookGenre=" + bookGenre +
                ", bookCollection=" + bookCollection +
                ", authors=" + authors +
                '}';
    }
}