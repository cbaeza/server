package com.cbaeza.server.api.whishlist;

import com.cbaeza.model.commons.ws.whishlist.WSWishlist;
import com.cbaeza.model.commons.ws.whishlist.WSWishlists;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public interface WhishlistManagementResource {

    void saveWhishlistItem(WSWishlist wsWishlist, String token);

    WSWishlist getWishlistItem(Long ID, String token);

    WSWishlists getWishlists(Long userID, String token);

    WSWishlist removeWishlistItem(Long ID, String token);


}
