package com.cbaeza.model.commons.ws.messages;

import com.cbaeza.model.commons.ws.WS;

/**
 * User: cbaeza
 * Since: 18.03.14
 */
public class ResponseMessage implements WS {

    private String message;
    private int statusCode;

    public ResponseMessage(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
