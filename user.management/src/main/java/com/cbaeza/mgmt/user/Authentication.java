package com.cbaeza.mgmt.user;

import org.springframework.stereotype.Service;

/**
 * User: cbaeza
 * Since: 24.01.14
 */
@Service
public class Authentication implements IAuthentication {

	private static Authentication instance;

	public static Authentication getInstance() {
		if (instance == null) {
			return new Authentication();
		}

		return instance;
	}

	public Authentication() {
		System.out.print("me instanciaron");
	}

	@Override
	public boolean identifyUserByEmailAndPassword(String email, String password) {
		return (email.equals("test@test.de") && password.equals("test"));
	}
}
