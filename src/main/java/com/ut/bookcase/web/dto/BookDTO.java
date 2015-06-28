package com.ut.bookcase.web.dto;

public class BookDTO {

    private String title;
    private String author;

    private BookDTO() {
    }

    public BookDTO(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
