package com.cbaeza.server.api;

import com.cbaeza.model.commons.authentication.WSAuthentication;
import com.cbaeza.persistence.management.users.AuthenticationMgmtImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * User: cbaeza
 * Since: 24.01.14
 */
@Controller
@RequestMapping("/users")
public class UserAuthenticationResource {

    // FIXME : try to inject Mgmts
    //@Autowired
    //private AuthenticationMgmtImpl authentication;

    /**
     * Example: http://localhost:8080/server-api/rest/users
     *
     * @return a dummy
     */
    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
    @ResponseBody
    public WSAuthentication hello() {
        return new WSAuthentication(1L, "dummy", UUID.randomUUID().toString());
    }

    /**
     * Example: http://localhost:8080/server-api/rest/users/authenticate/test@test/test
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/authenticate/{username}/{password}", method = RequestMethod.POST, headers = "Accept=application/json,application/xml")
    @ResponseBody
    public WSAuthentication authenticateUserByEmailAndPassword(@PathVariable("username") final String username, @PathVariable("password") final String password) {
        return AuthenticationMgmtImpl.getInstance().authenticateUser(username, password);
    }

    /*
    FIXME : does not work with PUT_

    @RequestMapping(value = "/authenticate", method = RequestMethod.PUT, headers = "Accept=application/xml,application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public WSAuthentication authenticateUserByEmailAndPassword(@RequestBody WSAuthentication authentication) {
        //final boolean b = Authentication.getInstance().identifyUserByEmailAndPassword(authentication.getUsername(), authentication.getToken());
        return new WSAuthentication(authentication.getUsername(), UUID.randomUUID().toString());
    } */
}
