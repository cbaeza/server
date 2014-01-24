package com.cbaeza.mgmt.user;

/**
 * User: cbaeza
 * Since: 24.01.14
 */
public interface IAuthentication {

    boolean identifyUserByEmailAndPassword(final String email, final String password);
}
