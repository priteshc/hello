package com.example.hp.ekeeda_vendor.presenter;




import android.util.Log;

import com.example.hp.ekeeda_vendor.backtask.RetrofitBuild;
import com.example.hp.ekeeda_vendor.inerface.Loginview;
import com.example.hp.ekeeda_vendor.model.LoginPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by pritesh on 10/2/2017.
 */

public class LoginPresenter {


    private Loginview loginview;

    private RetrofitBuild retrofitBuild;


    public LoginPresenter(Loginview loginview) {

        this.loginview = loginview;

        retrofitBuild = new RetrofitBuild();

    }


    public void getReg(String name, String password){

        loginview.showprogress();

        Call<LoginPojo> pojoCall = retrofitBuild.allApi().getRegister(name, password);


        pojoCall.enqueue(new Callback<LoginPojo>() {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {

                loginview.hideprogress();

                Log.d("Msg",String.valueOf(response.code()));

                if(response.body().getStatus().equals("SUCCESS")){


                    loginview.showRLoginSuccessMsg(response.body().getStatus(),response.body().getData(),response.body().getUserType());

                }
                else {


                    loginview.showFLoginSuccessMsg(response.body().getStatus());

                }

            }

            @Override
            public void onFailure(Call<LoginPojo> call, Throwable t) {

                loginview.hideprogress();

                System.out.println("Error:" + t.getMessage());

                loginview.showRErrorMeassage();

            }
        });


    }


}
