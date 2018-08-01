package com.example.hp.ekeeda_vendor;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.example.hp.ekeeda_vendor.adapter.Admin_Adapter;
import com.example.hp.ekeeda_vendor.inerface.Revenuview;
import com.example.hp.ekeeda_vendor.model.Detail;
import com.example.hp.ekeeda_vendor.model.GPlist;
import com.example.hp.ekeeda_vendor.presenter.RevenuePresenter;
import com.example.hp.ekeeda_vendor.util.NetworkUtil;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class AdminActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,Revenuview {

    private Calendar calendar;
    private TextView from,to,sales,commion;
    private Toolbar toolbar;
    private SweetAlertDialog pDialog;
    private String s,t,dat1;
    private SimpleDateFormat mSDFOld;
    private RippleView submit,viewall;
    private LinearLayout linearLayout;
    private Context context = AdminActivity.this;
    private RevenuePresenter revenuePresenter;
    private ProgressDialog progressDialog;
    int sal;
    String coupon,usertype;
    private SharedPreferences sharedPreferences;
    private List<Detail>detailList;
    List<GPlist>gPlists;
    private MaterialSpinner materialSpinner;
    private ArrayList<String> pername;
    private RecyclerView recyclerView;
     private Admin_Adapter adminAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin);

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("please wait...");
        progressDialog.setCancelable(false);

        recyclerView = findViewById(R.id.recordlist);

        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        sharedPreferences = this.getSharedPreferences("Coupon",0);

        coupon = sharedPreferences.getString("Cup","");
        usertype = sharedPreferences.getString("Type","");

        gPlists = new ArrayList<>();

        materialSpinner = (MaterialSpinner) findViewById(R.id.employee);

        pername = new ArrayList<>();

        adminAdapter = new Admin_Adapter(context);


        calendar = Calendar.getInstance();

        from = (TextView) findViewById(R.id.fr);
        to = (TextView) findViewById(R.id.to);
        submit = (RippleView) findViewById(R.id.more);


        mSDFOld = new SimpleDateFormat("yyyy/MM/dd");


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        revenuePresenter = new RevenuePresenter(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        detailList = new ArrayList<>();

        revenuePresenter.getLis("");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (NetworkUtil.getConnectivityStatus(AdminActivity.this.getApplicationContext()) != 0) {

                    if (!from.getText().toString().isEmpty() && !to.getText().toString().isEmpty() && materialSpinner.getSelectedIndex()!= 0) {

                        revenuePresenter.getReg(from.getText().toString(), to.getText().toString(), gPlists.get(materialSpinner.getSelectedIndex()-1).getCouponCode(),usertype);

                    } else {

                        Toast.makeText(context, "Please select date and vendor", Toast.LENGTH_SHORT).show();

                    }
                }
                else {
                    Toast.makeText(context,"Please check internet connection",Toast.LENGTH_SHORT).show();

                }


            }
        });




        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s="0";
                t="0";
                DatePickerDialog dpd1 = DatePickerDialog.newInstance(AdminActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                dpd1.show(getFragmentManager(), "datePicker");
                dpd1.setAccentColor(getResources().getColor(R.color.Blue));



            }
        });

        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s="1";
                t="1";
                DatePickerDialog dpd1 = DatePickerDialog.newInstance(AdminActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                dpd1.show(getFragmentManager(), "datePicker");
                dpd1.setAccentColor(getResources().getColor(R.color.Blue));

            }
        });


    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {


        int mon = monthOfYear + 1;
        String date1 = year + "/" + mon + "/" + dayOfMonth;
        String time = "00:00:00";
        String dat = date1;

        try {

            dat1 = mSDFOld.format(mSDFOld.parse(dat));

            //   System.out.println("Current time = "+time);
        }
        catch (Exception e){

            e.printStackTrace();
        }


        if(s.equals("0")){

            String datt = dat1;
            from.setText(datt);
        }

        if(t.equals("1")){

            //  time = time1;
            String datt = dat1;

            to.setText(datt);

        }
    }

    @Override
    public void showRErrorMeassage() {

        Toast.makeText(context,"Server error",Toast.LENGTH_LONG).show();

    }

    @Override
    public void showRLoginSuccessMsg(List<Detail> data,String sale,String comm) {

        linearLayout.setVisibility(View.VISIBLE);

        detailList = data;

        adminAdapter.SetList(data);

        recyclerView.setAdapter(adminAdapter);

    }

    @Override
    public void showListSuccessMsg(List<GPlist> data) {

        gPlists  = data;
        for(int i=0;i<data.size();i++) {

            pername.add(data.get(i).getFullName());

        }


        pername.add(0,"select Vendor");
        materialSpinner.setItems(pername);

    }

    @Override
    public void showFLoginSuccessMsg(String success) {

//        linearLayout.setVisibility(View.GONE);

        Toast.makeText(context,"No record found",Toast.LENGTH_LONG).show();

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






