package com.ut.bookcase.web.config;

import com.ut.bookcase.web.AdministrationController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/bookcase")
public class ApplicationConfig extends Application {

    public Set<Class<?>> getClasses() {
        return new HashSet<>(Collections.singletonList(AdministrationController.class));
    }
}
