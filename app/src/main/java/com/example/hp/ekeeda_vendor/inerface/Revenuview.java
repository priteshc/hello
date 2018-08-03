package com.example.hp.ekeeda_vendor.inerface;


import com.example.hp.ekeeda_vendor.model.Detail;
import com.example.hp.ekeeda_vendor.model.GPlist;

import java.util.List;

/**
 * Created by pritesh on 10/2/2017.
 */

public interface
Revenuview {


    void showRErrorMeassage();

    void showRLoginSuccessMsg(List<Detail> data,String sale,String comm);

    void showListSuccessMsg(List<GPlist> data);

    void showFLoginSuccessMsg(String success);

    void showPaySuccessMsg(String success);


    void showprogress();

    void hideprogress();


}
