package com.ut.bookcase.web.dto;

public class LendingDTO {

    private int borrowerId;
    private int bookId;

    private LendingDTO() {
    }

    public LendingDTO(int borrowerId, int bookId) {
        this.borrowerId = borrowerId;
        this.bookId = bookId;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public int getBookId() {
        return bookId;
    }
}
