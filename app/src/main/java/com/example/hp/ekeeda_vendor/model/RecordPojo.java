package com.example.hp.ekeeda_vendor.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordPojo {

    @SerializedName("Details")
    @Expose
    private List<Detail> details = null;
    @SerializedName("TotalSale")
    @Expose
    private String totalSale;
    @SerializedName("TotalCommision")
    @Expose
    private String totalCommision;

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public String getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(String totalSale) {
        this.totalSale = totalSale;
    }

    public String getTotalCommision() {
        return totalCommision;
    }

    public void setTotalCommision(String totalCommision) {
        this.totalCommision = totalCommision;
    }

}


