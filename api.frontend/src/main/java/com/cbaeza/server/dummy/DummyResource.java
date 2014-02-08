package com.cbaeza.server.dummy;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.authentication.WSAuthentication;
import com.cbaeza.model.commons.ws.errors.Error;
import com.cbaeza.model.commons.ws.errors.WSError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Place to probe new ideas !
 * <p/>
 * Root resource (exposed at "dummy" path)
 */
@Component
@RequestMapping("/dummy")
public class DummyResource {

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

    @RequestMapping(value = "/a", method = RequestMethod.PUT, headers = "Accept=application/json", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public WS aPUT(@RequestBody WSAuthentication wsAuthentication) {
        if (wsAuthentication == null)
            return new WSError(Error.INTERNAL_SERVER_ERROR.getCode(), "wsAuthentication is null");
        else
            return wsAuthentication;

    }
}
