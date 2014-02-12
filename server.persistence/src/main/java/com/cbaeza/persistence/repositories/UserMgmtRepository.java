package com.cbaeza.persistence.repositories;

import com.cbaeza.persistence.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User: cbaeza
 * Since: 07.02.14
 */
public interface UserMgmtRepository extends CrudRepository<User, Long> {

    @Query("FROM User")
    List<User> findAllUsers();

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findUserByUserName(String username);
}
