package com.ut.bookcase.web.dto;

public class BookDTO {

    private int id;
    private String title;
    private String author;
    private FriendDTO friendDTO;

    private BookDTO() {
    }

    public BookDTO(int id, String title, String author, FriendDTO friendDTO) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.friendDTO = friendDTO;
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

    public FriendDTO getFriendDTO() {
        return friendDTO;
    }
}
