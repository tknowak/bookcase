package com.ut.bookcase.web.dto;

public class LendingToNewPersonDTO {
    private String name;
    private int bookId;

    private LendingToNewPersonDTO() {
    }

    public LendingToNewPersonDTO(String name, int bookId) {
        this.name = name;
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public int getBookId() {
        return bookId;
    }
}
