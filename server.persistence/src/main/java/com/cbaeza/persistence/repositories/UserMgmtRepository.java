package com.cbaeza.persistence.repositories;

import com.cbaeza.persistence.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User: cbaeza
 * Since: 07.02.14
 */
public interface UserMgmtRepository extends CrudRepository<User, Long> {
}
