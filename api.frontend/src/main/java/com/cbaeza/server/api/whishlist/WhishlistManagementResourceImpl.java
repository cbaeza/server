package com.cbaeza.server.api.whishlist;

import com.cbaeza.model.commons.ws.whishlist.WSWishlist;
import com.cbaeza.model.commons.ws.whishlist.WSWishlists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
@Controller
@RequestMapping("/whishlist")
public class WhishlistManagementResourceImpl implements WhishlistManagementResource {

    @Override
    public void saveWhishlistItem(WSWishlist wsWishlist, String token) {

    }

    @Override
    public WSWishlist getWishlistItem(Long ID, String token) {
        return null;
    }

    @Override
    public WSWishlists getWishlists(Long userID, String token) {
        return null;
    }

    @Override
    public WSWishlist removeWishlistItem(Long ID, String token) {
        return null;
    }
}
