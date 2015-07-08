package com.ut.bookcase.web;

import com.ut.bookcase.service.FriendsService;
import com.ut.bookcase.web.dto.FriendDTO;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/friends")
public class FriendsController {

    @EJB
    private FriendsService friendsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FriendDTO> listAllFriends() {
        return friendsService.listAllFriends();
    }
}
