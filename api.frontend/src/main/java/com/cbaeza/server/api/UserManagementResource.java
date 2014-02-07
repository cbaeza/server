package com.cbaeza.server.api;

import com.cbaeza.model.commons.ws.WS;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * User: cbaeza
 * Since: 07.02.14
 */
public interface UserManagementResource {

    /**
     * Example: http://localhost:8080/server-api/rest/users/authenticate/test@test/test
     * Method: POST
     *
     * @param username username
     * @param password the password in SHA
     * @return
     */
    WS authenticateUserByEmailAndPassword(@PathVariable("username") final String username, @PathVariable("password") final String password);

    /**
     * TODO: Take care who are allowed to use this method.! Idea: maybe do not expone it?
     * Create a new user.
     * Example: http://localhost:8080/server-api/rest/users/create/carlos.baeza/test@test/test
     * Method: POST
     *
     * @param username e.g. user email
     * @param password the password in SHA
     * @return
     */
    WS createUser(@PathVariable("username") final String username, @PathVariable("email") final String email, @PathVariable("password") final String password);

    /**
     * Get user information.
     * Example: http://localhost:8080/server-api/rest/users/user/2000
     * Method: GET
     *
     * @param userID unique user ID
     * @return
     */
    WS getUserInformation(@PathVariable("userID") Long userID);

}
