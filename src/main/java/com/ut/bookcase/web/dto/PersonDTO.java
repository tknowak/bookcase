package com.ut.bookcase.web.dto;

public class PersonDTO {

    private int id;
    private String name;

    private PersonDTO() {
    }

    public PersonDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
