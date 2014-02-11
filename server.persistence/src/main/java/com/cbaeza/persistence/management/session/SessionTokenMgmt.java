package com.cbaeza.persistence.management.session;

import com.cbaeza.model.commons.ws.session.WSSessionTokens;

import java.util.List;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public interface SessionTokenMgmt {

    void saveSessionToken(Long userID, String token);

    String createToken();

    void removeToken(String token);

    boolean checkValidToken(String token);

    boolean expireToken(String token);

    WSSessionTokens getAllTokens();
}
