package com.ut.bookcase.web;

import com.ut.bookcase.service.LendingService;
import com.ut.bookcase.web.dto.LendingDTO;
import com.ut.bookcase.web.dto.LendingToNewFriendDTO;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/lend")
public class LendingController {

    @EJB
    private LendingService lendingService;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void lendBook(LendingDTO lendingDTO) {
        lendingService.lendBook(lendingDTO);
    }

    @PUT
    @Path("new-friend")
    @Consumes(MediaType.APPLICATION_JSON)
    public void lendBookToNewFriend(LendingToNewFriendDTO lendingDTO) {
        lendingService.lendBookToNewFriend(lendingDTO);
    }

    @PUT
    @Path("return")
    @Consumes(MediaType.APPLICATION_JSON)
    public void returnBook(LendingDTO lendingDTO) {
        lendingService.returnBook(lendingDTO.getBookId());
    }
}
