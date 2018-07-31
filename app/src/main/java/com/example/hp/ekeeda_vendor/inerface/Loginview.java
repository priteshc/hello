package com.example.hp.ekeeda_vendor.inerface;


import com.example.hp.ekeeda_vendor.model.LoginPojo;

import java.util.List;

/**
 * Created by pritesh on 10/2/2017.
 */

public interface
Loginview {


    void showRErrorMeassage();

    void showRLoginSuccessMsg(String success, List<String> data,String uertype);

    void showFLoginSuccessMsg(String success);

    void showprogress();

    void hideprogress();


}
