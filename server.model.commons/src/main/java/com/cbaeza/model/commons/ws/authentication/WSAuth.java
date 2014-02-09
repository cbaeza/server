package com.cbaeza.model.commons.ws.authentication;

import com.cbaeza.model.commons.ws.WS;

/**
 * User: cbaeza
 * Since: 09.02.14
 */
public class WSAuth implements WS {

    private String userID;
    private String password;

    public WSAuth(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
