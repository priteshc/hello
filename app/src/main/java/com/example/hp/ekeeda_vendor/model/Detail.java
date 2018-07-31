package com.example.hp.ekeeda_vendor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail {

    @SerializedName("OrderCode")
    @Expose
    private String orderCode;
    @SerializedName("OrderDate")
    @Expose
    private String orderDate;
    @SerializedName("Time")
    @Expose
    private String time;
    @SerializedName("vcrName")
    @Expose
    private String vcrName;
    @SerializedName("vcrSubject")
    @Expose
    private String vcrSubject;
    @SerializedName("Coupon")
    @Expose
    private String coupon;
    @SerializedName("numActualFees")
    @Expose
    private String numActualFees;
    @SerializedName("vcrEmail")
    @Expose
    private String vcrEmail;
    @SerializedName("vcrOrderID")
    @Expose
    private String vcrOrderID;
    @SerializedName("numActualReceived")
    @Expose
    private String numActualReceived;
    @SerializedName("vcrStatus")
    @Expose
    private String vcrStatus;
    @SerializedName("PaymentMode")
    @Expose
    private String paymentMode;
    @SerializedName("numWalletAmt")
    @Expose
    private String numWalletAmt;
    @SerializedName("vcrStream")
    @Expose
    private String vcrStream;
    @SerializedName("vcrUniversityName")
    @Expose
    private String vcrUniversityName;
    @SerializedName("vcrSemester")
    @Expose
    private String vcrSemester;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVcrName() {
        return vcrName;
    }

    public void setVcrName(String vcrName) {
        this.vcrName = vcrName;
    }

    public String getVcrSubject() {
        return vcrSubject;
    }

    public void setVcrSubject(String vcrSubject) {
        this.vcrSubject = vcrSubject;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getNumActualFees() {
        return numActualFees;
    }

    public void setNumActualFees(String numActualFees) {
        this.numActualFees = numActualFees;
    }

    public String getVcrEmail() {
        return vcrEmail;
    }

    public void setVcrEmail(String vcrEmail) {
        this.vcrEmail = vcrEmail;
    }

    public String getVcrOrderID() {
        return vcrOrderID;
    }

    public void setVcrOrderID(String vcrOrderID) {
        this.vcrOrderID = vcrOrderID;
    }

    public String getNumActualReceived() {
        return numActualReceived;
    }

    public void setNumActualReceived(String numActualReceived) {
        this.numActualReceived = numActualReceived;
    }

    public String getVcrStatus() {
        return vcrStatus;
    }

    public void setVcrStatus(String vcrStatus) {
        this.vcrStatus = vcrStatus;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getNumWalletAmt() {
        return numWalletAmt;
    }

    public void setNumWalletAmt(String numWalletAmt) {
        this.numWalletAmt = numWalletAmt;
    }

    public String getVcrStream() {
        return vcrStream;
    }

    public void setVcrStream(String vcrStream) {
        this.vcrStream = vcrStream;
    }

    public String getVcrUniversityName() {
        return vcrUniversityName;
    }

    public void setVcrUniversityName(String vcrUniversityName) {
        this.vcrUniversityName = vcrUniversityName;
    }

    public String getVcrSemester() {
        return vcrSemester;
    }

    public void setVcrSemester(String vcrSemester) {
        this.vcrSemester = vcrSemester;
    }

}