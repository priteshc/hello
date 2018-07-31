package com.example.hp.ekeeda_vendor;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.example.hp.ekeeda_vendor.inerface.Loginview;
import com.example.hp.ekeeda_vendor.presenter.LoginPresenter;
import com.example.hp.ekeeda_vendor.util.NetworkUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Loginview {

    private TextInputLayout username,password;
    private RippleView rippleView;
    private EditText uname,upassword;
     private Context context = MainActivity.this;

     private ProgressDialog progressDialog;
     private LoginPresenter loginPresenter;
     private SharedPreferences sharedPreferences;
     private NetworkUtil networkUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("Coupon",0);

        rippleView = (RippleView) findViewById(R.id.more);

        uname = (EditText) findViewById(R.id.uname);
        upassword = (EditText) findViewById(R.id.upassword);

        networkUtil = new NetworkUtil();

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("please wait...");
        progressDialog.setCancelable(false);

        username = findViewById(R.id.usrname);
        password = findViewById(R.id.password);

        loginPresenter = new LoginPresenter(this);

        rippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {

                if (NetworkUtil.getConnectivityStatus(MainActivity.this.getApplicationContext()) != 0) {

                    if (!uname.getText().toString().isEmpty() && !upassword.getText().toString().isEmpty()) {

                        loginPresenter.getReg(uname.getText().toString(), upassword.getText().toString());

                    } else {

                        Toast.makeText(context, R.string.error_field_required, Toast.LENGTH_SHORT).show();

                    }
                }
                else {

                    Toast.makeText(context,"Please check internet connection",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public void showRErrorMeassage() {

        Toast.makeText(context,"Server error",Toast.LENGTH_LONG).show();

    }

    @Override
    public void showRLoginSuccessMsg(String success, List<String> data,String usertype) {

        Toast.makeText(context,"Login Successsful",Toast.LENGTH_LONG).show();

        sharedPreferences.edit().putString("Cup",data.get(0)).putString("Type",usertype).apply();

        if(usertype.equals("User")) {

            Intent a = new Intent(context, Commission_Activity.class);
            startActivity(a);
            finish();

        }
        else {
            Intent a = new Intent(context, AdminActivity.class);
            startActivity(a);
            finish();

        }
    }

    @Override
    public void showFLoginSuccessMsg(String success) {

        Toast.makeText(context,"Login Fail",Toast.LENGTH_LONG).show();

    }

    @Override
    public void showprogress() {

        progressDialog.show();
    }

    @Override
    public void hideprogress() {

        progressDialog.dismiss();
    }
}
