package com.cbaeza.server.api;

import org.springframework.http.MediaType;
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

    //@Autowired
    //private Authentication authentication;

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/xml,application/json")
    @ResponseBody
    public WSAuthentication hello() {
        return new WSAuthentication("hello", UUID.randomUUID().toString());
    }

    /**
     * Example: http://localhost:8080/server-api/rest/users/authenticate/test@test/test
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/authenticate/{email}/{password}", method = RequestMethod.POST, headers = "Accept=application/xml,application/json")
    @ResponseBody
    public WSAuthentication authenticateUserByEmailAndPassword(@PathVariable("email") final String email, @PathVariable("password") final String password) {
        //final boolean b = Authentication.getInstance().identifyUserByEmailAndPassword(authentication.getUsername(), authentication.getToken());
        return new WSAuthentication(email, UUID.randomUUID().toString());
    }

    /*@RequestMapping(value = "/authenticate", method = RequestMethod.POST, headers = "Accept=application/xml,application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public WSAuthentication authenticateUserByEmailAndPassword(@RequestBody WSAuthentication authentication) {
        //final boolean b = Authentication.getInstance().identifyUserByEmailAndPassword(authentication.getUsername(), authentication.getToken());
        return new WSAuthentication(authentication.getUsername(), UUID.randomUUID().toString());
    } */
}
