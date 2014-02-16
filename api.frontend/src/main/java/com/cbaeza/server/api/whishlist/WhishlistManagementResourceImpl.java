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
@RequestMapping("/whishlist")
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

    /**
     * Example </br>
     * User 10000: http://localhost:8080/server-api/rest/whishlist/10000/35eb2185-9bfc-4ed8-ad60-a8506ee686b9
     * User 10001: http://localhost:8080/server-api/rest/whishlist/10001/38e62106-0910-4f94-b418-bfe646d11bc0
     *
     * @param userID a valid userID.
     * @param token  a valid token for user.
     * @return
     */
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
