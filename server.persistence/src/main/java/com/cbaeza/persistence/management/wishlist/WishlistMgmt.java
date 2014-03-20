package com.cbaeza.persistence.management.wishlist;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.wishlist.WSWishlist;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public interface WishlistMgmt {

    WS addItemToWishlist(WSWishlist wsWishlist, Long userID, String token);

    void removeItemFromWishlist(WSWishlist wsWishlist, Long userID, String token);

    WS getWishlist(Long userID, String token);

    WS getWishlistItem(Long userID, Long item, String token);
}
