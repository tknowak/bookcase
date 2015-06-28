package com.ut.bookcase.web;

import com.ut.bookcase.service.AdministrationService;
import com.ut.bookcase.web.dto.BookDTO;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class AdministrationController {

    @EJB
    private AdministrationService administrationService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBookToBookcase(BookDTO bookDTO) {
        administrationService.addBookToBookcase(bookDTO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDTO> listAllBooks() {
        return administrationService.listAllBooks();
    }
}
