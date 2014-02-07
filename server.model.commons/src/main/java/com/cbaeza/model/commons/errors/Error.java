package com.cbaeza.model.commons.errors;

/**
 * Commons errors
 *
 * User: cbaeza
 * Since: 07.02.14
 */
public enum Error {

    NOT_AUTHORIZED(1, "You are not authorized to use this api"),
    BAD_REQUEST(2, "You request is bad");

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
