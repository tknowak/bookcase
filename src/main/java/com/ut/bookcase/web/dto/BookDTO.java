package com.ut.bookcase.web.dto;

public class BookDTO {

    private int id;
    private String title;
    private String author;
    private PersonDTO personDTO;

    private BookDTO() {
    }

    public BookDTO(int id, String title, String author, PersonDTO personDTO) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.personDTO = personDTO;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public PersonDTO getPersonDTO() {
        return personDTO;
    }
}
