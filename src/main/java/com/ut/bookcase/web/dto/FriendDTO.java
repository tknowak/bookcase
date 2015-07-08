package com.ut.bookcase.web.dto;

public class FriendDTO {

    private int id;
    private String name;

    private FriendDTO() {
    }

    public FriendDTO(int id, String name) {
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
