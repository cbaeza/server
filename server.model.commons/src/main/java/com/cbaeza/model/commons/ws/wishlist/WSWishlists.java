package com.cbaeza.model.commons.ws.wishlist;

import com.cbaeza.model.commons.ws.WS;

import java.util.ArrayList;
import java.util.List;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public class WSWishlists implements WS {

    private List<WSWishlist> list;

    public WSWishlists() {
        this.list = new ArrayList<WSWishlist>(0);
    }

    public WSWishlists(List<WSWishlist> list) {
        this.list = list;
    }

    public List<WSWishlist> getList() {
        return list;
    }

    public void setList(List<WSWishlist> list) {
        this.list = list;
    }
}
