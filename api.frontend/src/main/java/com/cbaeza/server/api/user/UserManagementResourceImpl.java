package com.cbaeza.server.api.user;

import com.cbaeza.model.commons.ws.authentication.WSAuthentication;
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
 * Principal controller that expose user management functionality.
 * <p/>
 * User: cbaeza
 * Since: 24.01.14
 */
@Controller
@RequestMapping("/users")
public class UserManagementResourceImpl implements UserManagementResource {

    @Autowired
    private UserMgmtImpl userMgmt;

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
    @ResponseBody
    public WS hello() {
        return new WSAuthentication(1L, "dummy", UUID.randomUUID().toString());
    }

    @RequestMapping(value = "/authenticate/{username}/{password}", method = RequestMethod.POST, headers = "Accept=application/json,application/xml")
    @ResponseBody
    @Override
    public WS authenticateUserByEmailAndPassword(@PathVariable("username") final String username, @PathVariable("password") final String password) {
        return userMgmt.authenticateUser(username, password);
    }

    @RequestMapping(value = "/create/{username}/{email}/{password}", method = RequestMethod.POST, headers = "Accept=application/json,application/xml")
    @ResponseBody
    @Override
    public WS createUser(@PathVariable("username") String username, @PathVariable("email") String email, @PathVariable("password") String password) {
        return userMgmt.createUser(username, email, password);
    }

    @RequestMapping(value = "/user/{userID}", method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
    @ResponseBody
    @Override
    public WS getUserInformation(@PathVariable("userID") Long userID) {
        return userMgmt.getUserInformation(userID);
    }
}
