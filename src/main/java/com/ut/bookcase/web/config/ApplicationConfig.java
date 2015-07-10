package com.ut.bookcase.web.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.*;

@ApplicationPath("/app")
public class ApplicationConfig extends Application {

    public Set<Class<?>> getClasses() {
        List<Class<SetupStatus>> controllers = Collections.singletonList(SetupStatus.class);
        return new HashSet<>(controllers);
    }
}
