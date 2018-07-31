package com.example.hp.ekeeda_vendor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GPlist {

    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("OwnerName")
    @Expose
    private String ownerName;
    @SerializedName("ShopName")
    @Expose
    private String shopName;
    @SerializedName("CouponCode")
    @Expose
    private String couponCode;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

}