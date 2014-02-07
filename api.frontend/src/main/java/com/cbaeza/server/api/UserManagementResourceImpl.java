package com.cbaeza.server.api;

import com.cbaeza.model.commons.authentication.WSAuthentication;
import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.persistence.management.users.UserMgmtImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * Principal controller that expone user management functionality.
 * <p/>
 * User: cbaeza
 * Since: 24.01.14
 */
@Controller
@RequestMapping("/users")
public class UserManagementResourceImpl implements UserManagementResource {

    @Autowired
    private UserMgmtImpl userMgmt;

    /**
     * Example: http://localhost:8080/server-api/rest/users
     * Method: GET
     *
     * @return a dummy hello
     */
    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
    @ResponseBody
    public WS hello() {
        return new WSAuthentication(1L, "dummy", UUID.randomUUID().toString());
    }

    /**
     * Example: http://localhost:8080/server-api/rest/users/authenticate/test@test/test
     * Method: POST
     *
     * @param username username
     * @param password the password in SHA
     * @return
     */
    @RequestMapping(value = "/authenticate/{username}/{password}", method = RequestMethod.POST, headers = "Accept=application/json,application/xml")
    @ResponseBody
    @Override
    public WS authenticateUserByEmailAndPassword(@PathVariable("username") final String username, @PathVariable("password") final String password) {
        return userMgmt.authenticateUser(username, password);
    }

    /**
     * Create a new user.
     * Example: http://localhost:8080/server-api/rest/users/create/carlos.baeza/test@test/test
     * Method: POST
     *
     * @param username e.g. user email
     * @param password the password in SHA
     * @return
     */
    @RequestMapping(value = "/create/{username}/{email}/{password}", method = RequestMethod.POST, headers = "Accept=application/json,application/xml")
    @ResponseBody
    @Override
    public WS createUser(@PathVariable("username") String username, @PathVariable("email") String email, @PathVariable("password") String password) {
        return userMgmt.createUser(username, email, password);
    }
}
