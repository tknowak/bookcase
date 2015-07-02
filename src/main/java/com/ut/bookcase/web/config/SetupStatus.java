package com.ut.bookcase.web.config;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/status")
public class SetupStatus {

    @GET
    public String check() {
        return "Application is up and running!";
    }
}
