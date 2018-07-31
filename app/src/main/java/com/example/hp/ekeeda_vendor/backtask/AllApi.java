package com.example.hp.ekeeda_vendor.backtask;


import android.support.annotation.Nullable;

import com.example.hp.ekeeda_vendor.model.ListPojo;
import com.example.hp.ekeeda_vendor.model.LoginPojo;
import com.example.hp.ekeeda_vendor.model.RecordPojo;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by pritesh on 3/27/2017.
 */

public interface AllApi {

    @FormUrlEncoded
    @POST("User")
    Call<LoginPojo> getRegister(@Field("Username") String uname, @Field("Password") String pass);

    @FormUrlEncoded
    @POST("GrowthReport")
    Call<RecordPojo> getVendersales(@Field("FDate") String fdat, @Field("TDate") String tdat,@Field("Coupon") String coupon,@Field("UserType") String type);


    @FormUrlEncoded
    @POST("GrowthPartnerList")
    Call<ListPojo> getList(@Field("Fdate") String uname);


    //, @Field("Coupon") String coupon
}
