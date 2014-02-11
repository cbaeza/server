package com.cbaeza.persistence.management.users;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.authentication.WSAuthentication;
import com.cbaeza.model.commons.ws.errors.Error;
import com.cbaeza.model.commons.ws.errors.WSError;
import com.cbaeza.model.commons.ws.user.WSUser;
import com.cbaeza.model.commons.ws.user.WSUsers;
import com.cbaeza.persistence.domain.User;
import com.cbaeza.persistence.repositories.UserMgmtRepository;
import com.cbaeza.persistence.utils.PersistenceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

/**
 * User: cbaeza
 * Since: 06.02.14
 */
@Component
public class UserMgmtImpl implements UserMgmt {

	private static UserMgmt instance;

	@Autowired
	private UserMgmtRepository userMgmtRepository;

	// anywhay, expose  singleton
	public static UserMgmt getInstance() {
		if (instance == null)
			instance = new UserMgmtImpl();

		return instance;
	}

	@Override
	public WSAuthentication authenticateUser(String username, String password) {
		// TODO impl with persistence
		return new WSAuthentication(1L, username, UUID.randomUUID().toString());
	}

	@Override
	public WSUser createUser(String username, String userEmail, String password) {
		// TODO impl with persistence
		return new WSUser(2L, username, userEmail, GregorianCalendar.getInstance().getTime(), GregorianCalendar.getInstance().getTime());
	}

	@Override
	public WS getUserInformation(Long userID) {
		final User user = userMgmtRepository.findOne(userID);

		if (user == null)
			return new WSError(Error.NOT_FOUND);


		return PersistenceUtils.transform(user);
	}

	@Override
	public WSUsers getAllUsers() {
		final List<User> allUsers = userMgmtRepository.findAllUsers();
		return PersistenceUtils.transformList(allUsers);
	}
}
