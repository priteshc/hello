package com.example.hp.ekeeda_vendor.presenter;




import android.util.Log;

import com.example.hp.ekeeda_vendor.backtask.RetrofitBuild;
import com.example.hp.ekeeda_vendor.inerface.Loginview;
import com.example.hp.ekeeda_vendor.inerface.Revenuview;
import com.example.hp.ekeeda_vendor.model.ListPojo;
import com.example.hp.ekeeda_vendor.model.LoginPojo;
import com.example.hp.ekeeda_vendor.model.Paypojo;
import com.example.hp.ekeeda_vendor.model.RecordPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pritesh on 10/2/2017.
 */

public class RevenuePresenter {


    private Revenuview loginview;

    private RetrofitBuild retrofitBuild;


    public RevenuePresenter(Revenuview loginview) {

        this.loginview = loginview;

        retrofitBuild = new RetrofitBuild();

    }


    public void getReg(String fdate, String tdate,String coupon,String usertype){

        loginview.showprogress();

        Call<RecordPojo> pojoCall = retrofitBuild.allApi().getVendersales(fdate, tdate,coupon,usertype);


        pojoCall.enqueue(new Callback<RecordPojo>() {
            @Override
            public void onResponse(Call<RecordPojo> call, Response<RecordPojo> response) {

                loginview.hideprogress();

                Log.d("Msg",String.valueOf(response.code()));

                if(response.body().getDetails().size()> 0){


                    loginview.showRLoginSuccessMsg(response.body().getDetails(),response.body().getTotalSale(),response.body().getTotalCommision());

                }
                else {


                    loginview.showFLoginSuccessMsg("no data");

                }

            }

            @Override
            public void onFailure(Call<RecordPojo> call, Throwable t) {

                loginview.hideprogress();

                System.out.println("Error:" + t.getMessage());

                loginview.showRErrorMeassage();

            }
        });


    }


    public void getLis(String fdate){

        loginview.showprogress();

        Call<ListPojo> pojoCall = retrofitBuild.allApi().getList(fdate);

        pojoCall.enqueue(new Callback<ListPojo>() {
            @Override
            public void onResponse(Call<ListPojo> call, Response<ListPojo> response) {

                loginview.hideprogress();

                Log.d("Msg",String.valueOf(response.code()));

                if(response.body().getGPlist().size()> 0){


                    loginview.showListSuccessMsg(response.body().getGPlist());

                }
                else {


                    loginview.showFLoginSuccessMsg("no data");

                }

            }

            @Override
            public void onFailure(Call<ListPojo> call, Throwable t) {

                loginview.hideprogress();

                System.out.println("Error:" + t.getMessage());

                loginview.showRErrorMeassage();

            }
        });


    }

    public void getpay(String fdate){

        loginview.showprogress();

        Call<Paypojo> pojoCall = retrofitBuild.allApi().getUpdate(fdate);

        pojoCall.enqueue(new Callback<Paypojo>() {
            @Override
            public void onResponse(Call<Paypojo> call, Response<Paypojo> response) {

                loginview.hideprogress();

                Log.d("Msg",String.valueOf(response.code()));

               loginview.showPaySuccessMsg(response.message());

            }

            @Override
            public void onFailure(Call<Paypojo> call, Throwable t) {

                loginview.hideprogress();

                System.out.println("Error:" + t.getMessage());

                loginview.showRErrorMeassage();

            }
        });


    }





}
