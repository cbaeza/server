package com.cbaeza.persistence.management.users;

import com.cbaeza.model.commons.ws.authentication.WSAuthentication;
import com.cbaeza.model.commons.ws.user.WSUser;
import org.springframework.stereotype.Component;

import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * User: cbaeza
 * Since: 06.02.14
 */
@Component
public class UserMgmtImpl implements UserMgmt {

    private static UserMgmt instance;

    // anywhay, expone  singleton
    public static UserMgmt getInstance() {
        if (instance == null)
            return new UserMgmtImpl();
        else
            return instance;
    }

    @Override
    public WSAuthentication authenticateUser(String username, String password) {
        // TODO impl with persistence
        return new WSAuthentication(1L, username, UUID.randomUUID().toString());
    }

    @Override
    public WSUser createUser(String username, String userEmail, String password) {
        // TODO impl with persistence
        return new WSUser(2L, username, userEmail, GregorianCalendar.getInstance().getTime(), GregorianCalendar.getInstance().getTime());
    }

    @Override
    public WSUser getUserInformation(Long userID) {
        // TODO impl with persistence
        return new WSUser(userID, "dummy", "dummy@dummy.de", GregorianCalendar.getInstance().getTime(), GregorianCalendar.getInstance().getTime());
    }
}
