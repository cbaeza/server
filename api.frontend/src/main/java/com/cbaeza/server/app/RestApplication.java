package com.cbaeza.server.app;

import com.cbaeza.server.api.UserAuthenticationResource;
import com.cbaeza.server.dummy.MyResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User: cbaeza
 * Since: 24.01.14
 */
@ApplicationPath("/api")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(MyResource.class, UserAuthenticationResource.class));
    }
}
