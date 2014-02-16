package com.cbaeza.model.commons.ws.whishlist;

import com.cbaeza.model.commons.ws.WS;

import java.util.Date;

/**
 * User: cbaeza
 * Since: 11.02.14
 */
public class WSWishlist implements WS {

    private String ID;
    private String userID;
    private String productID;
    private String productType;
    private Date creationDate;

    public WSWishlist(String ID, String userID, String productID, String productType, Date creationDate) {
        this.ID = ID;
        this.userID = userID;
        this.productID = productID;
        this.productType = productType;
        this.creationDate = creationDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

