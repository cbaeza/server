package com.cbaeza.server.api;

import com.cbaeza.model.commons.ws.WS;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * User: cbaeza
 * Since: 07.02.14
 */
public interface UserManagementResource {

    WS authenticateUserByEmailAndPassword(@PathVariable("username") final String username, @PathVariable("password") final String password);
}
