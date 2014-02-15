package com.cbaeza.persistence.repositories;

import com.cbaeza.persistence.domain.Token;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public interface TokenMgmtRepository extends CrudRepository<Token, Long> {

    @Query("FROM Token")
    List<Token> findAllTokens();

    @Query("SELECT t FROM Token t WHERE t.token = ?1")
    Token findToken(String token);
}
