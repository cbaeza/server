package com.cbaeza.server.api;

import com.cbaeza.mgmt.user.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * User: cbaeza
 * Since: 24.01.14
 */
@Path("user")
@Component
public class UserAuthenticationResource {

    @Autowired
    private Authentication authentication;

    @GET
    @Path("authenticate/{email}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public String authenticateUserByEmailAndPassword(@PathParam("email") final String email, @PathParam("password") final String password) {
        if (authentication == null) {
            throw new RuntimeException("authentication == null");
        }
        final boolean b = Authentication.getInstance().identifyUserByEmailAndPassword(email, password);
        return "authenticate: " + b;
    }
}
