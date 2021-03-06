package com.cbaeza.server.api.wishlist;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.wishlist.WSWishlist;
import com.cbaeza.persistence.management.wishlist.WishlistMgmtImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
@Controller
@RequestMapping("/wishlist")
public class WishlistManagementResourceImpl implements WishlistManagementResource {

    @Autowired
    private WishlistMgmtImpl whishlistMgmt;

    @RequestMapping(value = "/save/{userID}/{token}", method = RequestMethod.POST, headers = "Accept=application/json,application/xml")
    @ResponseBody
    @Override
    public WS saveWishlistItem(@RequestBody WSWishlist wsWishlist, @PathVariable("userID") Long userID, @PathVariable("token") String token) {
        return whishlistMgmt.addItemToWishlist(wsWishlist, userID, token);
    }

    @RequestMapping(value = "/{userid}/{item}/{token}", method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
    @ResponseBody
    @Override
    public WS getWishlistItem(@PathVariable("userid") Long userID, @PathVariable("item") Long item, @PathVariable("token") String token) {
        return whishlistMgmt.getWishlistItem(userID, item, token);
    }

    @RequestMapping(value = "/{userid}/{token}", method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
    @ResponseBody
    @Override
    public WS getWishlist(@PathVariable("userid") Long userID, @PathVariable("token") String token) {
        return whishlistMgmt.getWishlist(userID, token);
    }

    @Override
    public WSWishlist removeWishlistItem(Long ID, String token) {
        return null;
    }
}
