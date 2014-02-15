package com.cbaeza.persistence.management.session;

import com.cbaeza.model.commons.ws.session.WSSessionTokens;
import com.cbaeza.persistence.domain.Token;
import com.cbaeza.persistence.repositories.TokenMgmtRepository;
import com.cbaeza.persistence.utils.PersistenceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
@Service
public class SessionTokenMgmtImpl implements SessionTokenMgmt {

    @Autowired
    private TokenMgmtRepository tokenMgmtRepository;

    @Override
    public void saveSessionToken(Long userID, String token) {
        final Token sessionToken = new Token(userID, token, GregorianCalendar.getInstance().getTime(), GregorianCalendar.getInstance().getTime(), true);
        tokenMgmtRepository.save(sessionToken);
    }

    @Override
    public String createToken() {
        // TODO make a better token ;-)
        return UUID.randomUUID().toString();
    }

    @Override
    public void removeToken(String token) {

    }

    @Override
    public boolean checkValidToken(String token) {
        return false;
    }

    @Override
    public boolean expireToken(String token) {
        return false;
    }

    @Override
    public WSSessionTokens getAllTokens() {
        final List<Token> allTokens = tokenMgmtRepository.findAllTokens();
        return PersistenceUtils.transformListToWSSessionTokens(allTokens);
    }
}