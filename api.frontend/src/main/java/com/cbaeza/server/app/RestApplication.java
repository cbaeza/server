package com.cbaeza.server.app;

import com.cbaeza.server.api.UserAuthenticationResource;
import com.cbaeza.server.dummy.MyResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

/**
 * User: cbaeza
 * Since: 24.01.14
 */
public class RestApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public RestApplication() {
        register(RequestContextFilter.class);
        register(UserAuthenticationResource.class);
        register(MyResource.class);
    }
}