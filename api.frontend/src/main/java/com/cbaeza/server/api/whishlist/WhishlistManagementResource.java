package com.cbaeza.server.api.whishlist;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.whishlist.WSWishlist;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public interface WhishlistManagementResource {

    void saveWhishlistItem(WSWishlist wsWishlist, String token);

    WSWishlist getWishlistItem(Long ID, String token);

    WS getWishlists(Long userID, String token);

    WSWishlist removeWishlistItem(Long ID, String token);


}
