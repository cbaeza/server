package com.cbaeza.model.commons.ws.errors;

import com.cbaeza.model.commons.ws.WS;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Generic class to represent errorCode
 * <p/>
 * User: cbaeza
 * Since: 07.02.14
 */
public class WSError implements WS {

    private int errorCode;
    private String message;
    private Date timestamp;

    public WSError(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = GregorianCalendar.getInstance().getTime();
    }

    public WSError(Error error) {
        this.errorCode = error.getCode();
        this.message = error.getMessage();
        this.timestamp = GregorianCalendar.getInstance().getTime();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
