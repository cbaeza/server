package com.cbaeza.persistence.management.users;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.authentication.WSAuthentication;
import com.cbaeza.model.commons.ws.errors.Error;
import com.cbaeza.model.commons.ws.errors.WSError;
import com.cbaeza.model.commons.ws.user.WSUser;
import com.cbaeza.model.commons.ws.user.WSUsers;
import com.cbaeza.persistence.domain.User;
import com.cbaeza.persistence.repositories.UserMgmtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

/**
 * User: cbaeza
 * Since: 06.02.14
 */
@Component
public class UserMgmtImpl implements UserMgmt {

    private static UserMgmt instance;

    @Autowired
    private UserMgmtRepository userMgmtRepository;

    // anywhay, expose  singleton
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
    public WS getUserInformation(Long userID) {
        final User user = userMgmtRepository.findOne(userID);

        if (user == null)
            return new WSError(Error.NOT_FOUND);

        // wrapper to WS, why? so we can decide what we are exposing in WS world
        return new WSUser(Long.valueOf(user.getId()), user.getUsername(), user.getEmail(), user.getCreationdate(), user.getLastupdate());
    }

    @Override
    public WSUsers getAllUsers() {
        final List<User> allUsers = userMgmtRepository.findAllUsers();
        final List<WSUser> wsUsers = new ArrayList<WSUser>();
        // wrapper to WS, why? so we can decide what we are exposing in WS world
        for (User u : allUsers) {
            wsUsers.add(new WSUser(Long.valueOf(u.getId()), u.getUsername(), u.getEmail(), u.getCreationdate(), u.getLastupdate()));
        }
        return new WSUsers(wsUsers);
    }
}
