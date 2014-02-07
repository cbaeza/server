package com.cbaeza.persistence.utils;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.errors.Error;
import com.cbaeza.model.commons.ws.errors.WSError;
import com.cbaeza.model.commons.ws.user.WSUser;
import com.cbaeza.model.commons.ws.user.WSUsers;
import com.cbaeza.persistence.domain.User;

import java.util.List;

/**
 * User: cbaeza
 * Since: 07.02.14
 */
public class PersistenceUtils {

    /**
     * Wrapper to WS, why? so we can decide what we are exposing in WS world
     *
     * @param list
     * @return
     */
    public static WSUsers transformList(List<User> list) {
        if (list == null || list.isEmpty())
            return new WSUsers();

        final WSUsers result = new WSUsers();
        for (User u : list) {
            result.getWsUsers().add(new WSUser(Long.valueOf(u.getId()), u.getUsername(), u.getEmail(), u.getCreationdate(), u.getLastupdate()));
        }
        return result;
    }

    /**
     * Wrapper to WS, why? so we can decide what we are exposing in WS world
     *
     * @param user
     * @return
     */
    public static WS transform(User user) {
        if (user == null)
            return new WSError(Error.NOT_FOUND);
        else
            return new WSUser(Long.valueOf(user.getId()), user.getUsername(), user.getEmail(), user.getCreationdate(), user.getLastupdate());
    }
}
