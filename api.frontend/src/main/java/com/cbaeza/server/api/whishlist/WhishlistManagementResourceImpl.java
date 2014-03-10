package com.cbaeza.server.api.whishlist;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.whishlist.WSWishlist;
import com.cbaeza.persistence.management.whishlist.WhishlistMgmtImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
@Controller
@RequestMapping("/wishlist")
public class WhishlistManagementResourceImpl implements WhishlistManagementResource {

    @Autowired
    private WhishlistMgmtImpl whishlistMgmt;

    @Override
    public void saveWhishlistItem(WSWishlist wsWishlist, String token) {

    }

    @Override
    public WSWishlist getWishlistItem(Long ID, String token) {
        return null;
    }

    @RequestMapping(value = "/{userid}/{token}", method = RequestMethod.GET, headers = "Accept=application/json,application/xml")
    @ResponseBody
    @Override
    public WS getWishlists(@PathVariable("userid") Long userID, @PathVariable("token") String token) {
        return whishlistMgmt.getWishlist(userID, token);
    }

    @Override
    public WSWishlist removeWishlistItem(Long ID, String token) {
        return null;
    }
}
