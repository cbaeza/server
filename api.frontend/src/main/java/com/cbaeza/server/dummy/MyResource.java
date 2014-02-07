package com.cbaeza.server.dummy;

import com.cbaeza.model.commons.errors.Error;
import com.cbaeza.model.commons.errors.WSError;
import com.cbaeza.model.commons.ws.WS;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Root resource (exposed at "myresource" path)
 */
@Component
@RequestMapping("/dummy")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
    @ResponseBody
    public String getIt() {
        return "Got it!";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
    @ResponseBody
    public WS showError() {
        return new WSError(Error.NOT_AUTHORIZED.getCode(), "that is a test error");
    }

}
