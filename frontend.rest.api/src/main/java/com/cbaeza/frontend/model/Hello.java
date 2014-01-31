package com.cbaeza.frontend.model;

/**
 * User: cbaeza
 * Since: 31.01.14
 */
public class Hello {

    private final long id;
    private final String content;

    public Hello(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }


}
