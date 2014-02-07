package com.cbaeza.persistence.management.users;

import com.cbaeza.model.commons.authentication.WSAuthentication;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * User: cbaeza
 * Since: 06.02.14
 */
@Component
public class AuthenticationMgmtImpl implements AuthenticationMgmt {

    private static AuthenticationMgmt instance;

    public static AuthenticationMgmt getInstance() {
        if (instance == null)
            return new AuthenticationMgmtImpl();
        else
            return instance;
    }

    @Override
    public WSAuthentication authenticateUser(String username, String password) {
        // TODO impl with persistence
        return new WSAuthentication(1L, username, UUID.randomUUID().toString());
    }
}
