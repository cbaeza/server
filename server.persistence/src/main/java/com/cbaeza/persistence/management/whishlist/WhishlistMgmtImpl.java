package com.cbaeza.persistence.management.whishlist;

import com.cbaeza.model.commons.ws.WS;
import com.cbaeza.model.commons.ws.errors.Error;
import com.cbaeza.model.commons.ws.errors.WSError;
import com.cbaeza.model.commons.ws.whishlist.WSWishlist;
import com.cbaeza.persistence.domain.Wishlist;
import com.cbaeza.persistence.management.session.SessionTokenMgmtImpl;
import com.cbaeza.persistence.repositories.WishlistMgmtRepository;
import com.cbaeza.persistence.utils.PersistenceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
@Component
public class WhishlistMgmtImpl implements WhishlistMgmt {

    @Autowired
    private WishlistMgmtRepository wishlistMgmtRepository;
    @Autowired
    private SessionTokenMgmtImpl sessionTokenMgmt;


    @Override
    public void addItemToWishlist(WSWishlist wsWishlist) {

    }

    @Override
    public void removeItemFromWishlist(WSWishlist wsWishlist) {

    }

    @Override
    public WS getWishlist(Long userID, String token) {
        final boolean valid = sessionTokenMgmt.checkValidTokenByUser(token, userID);

        if (valid) {
            final List<Wishlist> wishlistByUser = wishlistMgmtRepository.findWishlistByUser(userID);
            return PersistenceUtils.transformWishListToWSWishlist(wishlistByUser);
        } else {
            return new WSError(Error.NOT_AUTHORIZED);
        }
    }

    @Override
    public WS getWishlistItem(Long userID, Long item, String token) {
        final boolean valid = sessionTokenMgmt.checkValidTokenByUser(token, userID);

        if (valid) {
            final Wishlist wishlistItem = wishlistMgmtRepository.findWishlistItemByUser(userID, item);
            if (wishlistItem != null)
                return new WSWishlist(wishlistItem.getId(), wishlistItem.getUserid(), wishlistItem.getProductid(), wishlistItem.getProducttype(), wishlistItem.getCreationdate());
            else
                return new WSError(Error.NOT_FOUND);
        } else {
            return new WSError(Error.NOT_AUTHORIZED);
        }
    }


}
