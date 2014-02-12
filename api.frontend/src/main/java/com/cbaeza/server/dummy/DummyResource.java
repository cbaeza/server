package com.cbaeza.server.dummy;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.authentication.WSAuth;
import com.cbaeza.model.commons.ws.errors.Error;
import com.cbaeza.model.commons.ws.errors.WSError;
import com.cbaeza.persistence.management.session.SessionTokenMgmt;
import com.cbaeza.persistence.management.users.UserMgmtImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserMgmtImpl userMgmt;

    @Autowired
    private SessionTokenMgmt sessionTokenMgmt;

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

    @RequestMapping(value = "/a", method = RequestMethod.PUT,
            headers = "Accept=application/json,application/xml",
            consumes = "application/json,application/xml",
            produces = "application/json,application/xml")
    @ResponseBody
    public WS aPUT(@RequestBody WSAuth wsAuth) {
        if (wsAuth == null)
            return new WSError(Error.INTERNAL_SERVER_ERROR.getCode(), "WSAuth is null");
        else
            //return new WSAuthentication(1L, wsAuth.getUserID(), UUID.randomUUID().toString());
            return wsAuth;
    }

    @RequestMapping(value = "tokens", method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
    @ResponseBody
    public WS getAllTokens() {
        return sessionTokenMgmt.getAllTokens();
    }

}
