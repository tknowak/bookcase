package com.ut.bookcase.web.dto;

public class LendingToNewFriendDTO {
    private String name;
    private int bookId;

    private LendingToNewFriendDTO() {
    }

    public LendingToNewFriendDTO(String name, int bookId) {
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
