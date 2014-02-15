package com.cbaeza.model.commons.ws.session;

import com.cbaeza.model.commons.ws.WS;

import java.util.Date;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public class WSSessionToken implements WS {

    private Long ID;
    private Long userID;
    private String token;
    private Date creationDate;
    private Date lastTouch;
    private boolean valid;

    public WSSessionToken(Long ID, Long userID, String token, Date creationDate, Date lastTouch, boolean valid) {
        this.ID = ID;
        this.userID = userID;
        this.token = token;
        this.creationDate = creationDate;
        this.lastTouch = lastTouch;
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastTouch() {
        return lastTouch;
    }

    public void setLastTouch(Date lastTouch) {
        this.lastTouch = lastTouch;
    }
}
