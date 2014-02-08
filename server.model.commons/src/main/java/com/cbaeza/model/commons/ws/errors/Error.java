package com.cbaeza.model.commons.ws.errors;

/**
 * Commons errors
 *
 * User: cbaeza
 * Since: 07.02.14
 */
public enum Error {

    NOT_AUTHORIZED(1, "You are not authorized to use this api"),
    NOT_FOUND(2, "not found"),
    INTERNAL_SERVER_ERROR(3, "internal error"),
    BAD_REQUEST(4, "You request is bad");

    private final String message;
    private int code;

    Error(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
