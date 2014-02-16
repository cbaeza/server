package com.cbaeza.persistence.management.whishlist;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.whishlist.WSWishlists;
import com.cbaeza.model.commons.ws.whishlist.WSWishlist;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public interface WhishlistMgmt {

    void addItemToWishlist(WSWishlist wsWishlist);

    void removeItemFromWishlist(WSWishlist wsWishlist);

    WS getWishlist(Long userID, String token);
}
