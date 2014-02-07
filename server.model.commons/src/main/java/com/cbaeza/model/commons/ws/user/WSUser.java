package com.cbaeza.model.commons.ws.user;

import com.cbaeza.model.commons.ws.WS;

import java.util.Date;

/**
 * User: cbaeza
 * Since: 07.02.14
 */
public class WSUser implements WS {

    private Long userID;
    private String username;
    private String userEmail;
    private Date creationDate;
    private Date lastUpdate;

    public WSUser(Long userID, String username, String userEmail, Date creationDate, Date lastUpdate) {
        this.userID = userID;
        this.username = username;
        this.userEmail = userEmail;
        this.creationDate = creationDate;
        this.lastUpdate = lastUpdate;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
