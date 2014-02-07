package com.cbaeza.persistence.management.users;

import com.cbaeza.model.commons.authentication.WSAuthentication;
import com.cbaeza.model.commons.user.WSUser;

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
    WSAuthentication authenticateUser(String username, String password);

    /**
     * Create a single user in server.
     *
     * @param username  the username
     * @param userEmail the user email
     * @param password  user password coded in SHA
     * @return
     */
    WSUser createUser(String username, String userEmail, String password);

    /**
     * Return basic user information.
     *
     * @param userID the unique user ID
     * @return
     */
    WSUser getUserInformation(Long userID);
}
