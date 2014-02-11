package com.cbaeza.persistence.management.users;

import com.cbaeza.model.commons.ws.WS;

/**
 * User: cbaeza
 * Since: 06.02.14
 */
public interface UserMgmt {

    /**
     * Authenticate a single user using username and credentials. If user are valid return a token to identify it valid session in the server.
     *
     * @param username user name or email
     * @param password user password coded in SHA
     * @return
     */
    WS authenticateUser(String username, String password);

    /**
     * Create a single user in server.
     *
     * @param username  the username
     * @param userEmail the user email
     * @param password  user password coded in SHA
     * @return
     */
    com.cbaeza.model.commons.ws.WS createUser(String username, String userEmail, String password);

    /**
     * Return basic user information.
     *
     * @param userID the unique user ID
     * @return
     */
    com.cbaeza.model.commons.ws.WS getUserInformation(Long userID);

    /**
     * Return a list whit all users
     *
     * @return
     */
    com.cbaeza.model.commons.ws.WS getAllUsers();
}
