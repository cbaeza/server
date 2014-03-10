package com.cbaeza.server.api.whishlist;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.whishlist.WSWishlist;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public interface WhishlistManagementResource {

    void saveWhishlistItem(WSWishlist wsWishlist, String token);

    /**
     * Example </br>
     * User 10000: http://localhost:8080/server-api/rest/wishlist/10000/35eb2185-9bfc-4ed8-ad60-a8506ee686b9
     * User 10001: http://localhost:8080/server-api/rest/wishlist/10001/38e62106-0910-4f94-b418-bfe646d11bc0
     *
     * @param ID    a valid userID.
     * @param token a valid token for user.
     * @return
     */
    WSWishlist getWishlistItem(Long ID, String token);

    WS getWishlists(Long userID, String token);

    WSWishlist removeWishlistItem(Long ID, String token);


}
