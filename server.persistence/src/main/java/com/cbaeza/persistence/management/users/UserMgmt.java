package com.cbaeza.persistence.management.users;

import com.cbaeza.model.commons.authentication.WSAuthentication;
import com.cbaeza.model.commons.user.WSUser;

import java.util.Date;

/**
 * User: cbaeza
 * Since: 06.02.14
 */
public interface UserMgmt {

    WSAuthentication authenticateUser(String username, String password);

    WSUser createUser(String username,  String userEmail, String password);
}
