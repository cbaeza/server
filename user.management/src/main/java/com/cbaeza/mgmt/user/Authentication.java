package com.cbaeza.mgmt.user;

/**
 * User: cbaeza
 * Since: 24.01.14
 */

public class Authentication implements IAuthentication {

    private static Authentication instance;

    public Authentication() {
        System.out.print("---> ME INSTANCIARON Authentication\n");
    }

    public static Authentication getInstance() {
        if (instance == null) {
            return new Authentication();
        }

        return instance;
    }

    @Override
    public boolean identifyUserByEmailAndPassword(String email, String password) {
        return (email.equals("test@test.de") && password.equals("test"));
    }
}
