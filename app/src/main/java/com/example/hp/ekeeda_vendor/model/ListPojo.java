package com.example.hp.ekeeda_vendor.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListPojo {

    @SerializedName("GPlist")
    @Expose
    private List<GPlist> gPlist = null;

    public List<GPlist> getGPlist() {
        return gPlist;
    }

    public void setGPlist(List<GPlist> gPlist) {
        this.gPlist = gPlist;
    }

}