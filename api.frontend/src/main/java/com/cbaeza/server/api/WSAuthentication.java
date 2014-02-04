package com.cbaeza.server.api;

/**
 * User: cbaeza
 * Since: 04.02.14
 */
public class WSAuthentication {

    private String username;
    private String token;

    public WSAuthentication(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
