package com.cbaeza.persistence.management.users;

import com.cbaeza.model.commons.authentication.WSAuthentication;

/**
 * User: cbaeza
 * Since: 06.02.14
 */
public interface AuthenticationMgmt {

    WSAuthentication authenticateUser(String username, String password);
}
