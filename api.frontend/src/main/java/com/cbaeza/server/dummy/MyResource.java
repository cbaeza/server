package com.cbaeza.server.dummy;

import org.springframework.stereotype.Component;

/**
 * Root resource (exposed at "myresource" path)
 */
@Component
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    public String getIt() {
        return "Got it!";
    }
}
