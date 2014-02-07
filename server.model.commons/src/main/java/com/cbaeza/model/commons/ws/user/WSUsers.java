package com.cbaeza.model.commons.ws.user;

import com.cbaeza.model.commons.ws.WS;

import java.util.List;

/**
 * User: cbaeza
 * Since: 07.02.14
 */
public class WSUsers implements WS {

    private List<WSUser> wsUsers;

    public WSUsers(List<WSUser> wsUsers) {
        this.wsUsers = wsUsers;
    }

    public List<WSUser> getWsUsers() {
        return wsUsers;
    }

    public void setWsUsers(List<WSUser> wsUsers) {
        this.wsUsers = wsUsers;
    }
}
