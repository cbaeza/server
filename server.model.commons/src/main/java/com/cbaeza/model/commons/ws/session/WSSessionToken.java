package com.cbaeza.model.commons.ws.session;

import com.cbaeza.model.commons.ws.WS;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public class WSSessionToken implements WS {

    private String token;

    public WSSessionToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
