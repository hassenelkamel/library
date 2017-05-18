package com.jee.library.model.dto;

/**
 * Created by Viktoriia_Moiseienko on 4/12/2017.
 */
public class BookCollectionDto {

    private Long id;
    private String name;

    public BookCollectionDto() {
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

}
