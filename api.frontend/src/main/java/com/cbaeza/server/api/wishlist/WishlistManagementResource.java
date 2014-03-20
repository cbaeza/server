package com.cbaeza.server.api.wishlist;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.wishlist.WSWishlist;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public interface WishlistManagementResource {

    WS saveWishlistItem(WSWishlist wsWishlist, Long userID, String token);

    /**
     * Example </br>
     * User 10000: http://localhost:8181/server-api/rest/wishlist/10000/1/35eb2185-9bfc-4ed8-ad60-a8506ee686b9
     * User 10001: http://localhost:8181/server-api/rest/wishlist/10001/5/38e62106-0910-4f94-b418-bfe646d11bc0
     *
     * @param userID a valid userID.
     * @param item   a valid item.
     * @param token  a valid token for user.
     * @return
     */
    WS getWishlistItem(Long userID, Long item, String token);

    /**
     * Example </br>
     * User 10000: http://localhost:8181/server-api/rest/wishlist/10000/35eb2185-9bfc-4ed8-ad60-a8506ee686b9
     * User 10001: http://localhost:8181/server-api/rest/wishlist/10001/38e62106-0910-4f94-b418-bfe646d11bc0
     *
     * @param userID a valid userID.
     * @param token  a valid token for user.
     * @return
     */
    WS getWishlist(Long userID, String token);

    WS removeWishlistItem(Long ID, String token);


}
