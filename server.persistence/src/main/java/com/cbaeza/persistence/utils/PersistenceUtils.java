package com.cbaeza.persistence.utils;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.errors.Error;
import com.cbaeza.model.commons.ws.errors.WSError;
import com.cbaeza.model.commons.ws.session.WSSessionToken;
import com.cbaeza.model.commons.ws.session.WSSessionTokens;
import com.cbaeza.model.commons.ws.user.WSUser;
import com.cbaeza.model.commons.ws.user.WSUsers;
import com.cbaeza.persistence.domain.Token;
import com.cbaeza.persistence.domain.User;

import java.util.List;

/**
 * Wrapper to WS, why? so we can decide what we are exposing in WS world
 * <p/>
 * User: cbaeza
 * Since: 07.02.14
 */
public class PersistenceUtils {

    /**
     * Wrapper
     *
     * @param list
     * @return
     */
    public static WSUsers transformListToWsUsers(List<User> list) {
        if (list == null || list.isEmpty())
            return new WSUsers();

        final WSUsers result = new WSUsers();
        for (User u : list) {
            result.getWsUsers().add(new WSUser(Long.valueOf(u.getId()), u.getUsername(), u.getEmail(), u.getCreationdate(), u.getLastupdate()));
        }
        return result;
    }

    /**
     * Wrapper
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

    /**
     * Wrapper
     *
     * @param list
     * @return
     */
    public static WSSessionTokens transformListToWSSessionTokens(List<Token> list) {
        if (list == null || list.isEmpty())
            return new WSSessionTokens();

        final WSSessionTokens result = new WSSessionTokens();
        for (Token token : list) {
            result.getList().add(new WSSessionToken(token.getToken()));
        }
        return result;
    }
}
