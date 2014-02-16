package com.cbaeza.persistence.repositories;

import com.cbaeza.persistence.domain.User;
import com.cbaeza.persistence.domain.Wishlist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User: cbaeza
 * Since: 16.02.14
 */
public interface WishlistMgmtRepository extends CrudRepository<Wishlist, Long> {

    @Query("SELECT u FROM Wishlist u WHERE u.userid = ?1")
    List<Wishlist> findWishlistByUser(Long userid);
}
