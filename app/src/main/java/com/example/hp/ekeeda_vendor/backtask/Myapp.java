package com.example.hp.ekeeda_vendor.backtask;

import android.app.Application;
import android.content.Context;


/**
 * Created by yashwant on 6/17/2016.
 */
public class Myapp extends Application {

    private static Myapp instance;

    public static String BASE_URL ="http://ekeeda.com/gpapi/api/";


    public static String BASE_ID ="Sportika";

    public static final String TAG = Myapp.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;


    }

    public static Myapp getInstance()
    {

        return instance;
    }



    public static Context getapContext(){


        return instance.getApplicationContext();
    }



}