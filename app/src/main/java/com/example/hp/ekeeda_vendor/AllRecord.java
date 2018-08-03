package com.example.hp.ekeeda_vendor;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.ekeeda_vendor.inerface.Revenuview;
import com.example.hp.ekeeda_vendor.model.Detail;
import com.example.hp.ekeeda_vendor.model.GPlist;
import com.example.hp.ekeeda_vendor.presenter.RevenuePresenter;

import java.util.ArrayList;
import java.util.List;

public class AllRecord extends AppCompatActivity implements Revenuview {


    private Toolbar toolbar;
    private TableLayout t1,t2;

    private Context context = AllRecord.this;
    private RevenuePresenter revenuePresenter;
    private ProgressDialog progressDialog;
    private String fdate,todae,coupon;
    private List<Detail>detailList;
    private SharedPreferences sharedPreferences;
    private String usertype;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.record);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        t1 = (TableLayout) findViewById(R.id.main_table);

        t2 = (TableLayout) findViewById(R.id.main_table1);


        sharedPreferences = this.getSharedPreferences("Coupon",0);

        coupon = sharedPreferences.getString("Cup","");

        usertype = sharedPreferences.getString("Type","");

        detailList = new ArrayList<>();

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("please wait...");
        progressDialog.setCancelable(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        revenuePresenter = new RevenuePresenter(this);

        //revenuePresenter.getReg();

        if(getIntent().getExtras().getString("fdate")!=null){

            fdate = getIntent().getExtras().getString("fdate");
            todae = getIntent().getExtras().getString("tdate");

            revenuePresenter.getReg(fdate,todae,coupon,usertype);

        }

        inittab();

     //   datatab();
    }

    private void inittab(){

            TableRow tr_head = new TableRow(this);
            //  tr_head.setId(10);
            tr_head.setBackgroundColor(getResources().getColor(R.color.accent));
            tr_head.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));



            TextView label_date = new TextView(this);
            // label_date.setId(20);
            label_date.setText("Date");
            label_date.setTextColor(Color.WHITE);
              label_date.setPadding(10, 0, 0, 0);
            tr_head.addView(label_date);// add the column to the table row here

            TextView label_weight_kg = new TextView(this);
            // label_weight_kg.setId(21);// define id that must be unique
            label_weight_kg.setText("Subject"); // set the text for the header
            label_weight_kg.setTextColor(Color.WHITE); // set the color
            //   label_weight_kg.setPadding(5, 5, 5, 5); // set the padding (if required)
            tr_head.addView(label_weight_kg); // add the column to the table row here

            TextView label_weight_kg1 = new TextView(this);
            // label_weight_kg.setId(21);// define id that must be unique
            label_weight_kg1.setText("Amount"); // set the text for the header
            label_weight_kg1.setTextColor(Color.WHITE); // set the color
            //  label_weight_kg1.setPadding(55, 5, 5, 5); // set the padding (if required)
            tr_head.addView(label_weight_kg1);

            TextView label_weight_kg2 = new TextView(this);
            // label_weight_kg.setId(21);// define id that must be unique
            label_weight_kg2.setText("Status"); // set the text for the header
            label_weight_kg2.setTextColor(Color.WHITE); // set the color
             label_weight_kg2.setPadding(0, 0, 10, 0); // set the padding (if required)
            tr_head.addView(label_weight_kg2);



            t1.addView(tr_head, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));



    }

    @Override
    public void showRErrorMeassage() {

        Toast.makeText(context,"Server error",Toast.LENGTH_LONG).show();

    }

    @Override
    public void showRLoginSuccessMsg(List<Detail> data,String sale,String comm) {

       // Log.d("Val",String.valueOf(data.size()));

        detailList = data;

        for(int i=0; i< detailList.size(); i++){


            TableRow tr = new TableRow(this);
            tr.setMinimumHeight(70);

            Log.d("Val",detailList.get(i).getVcrSubject().toString());

            if(i%2!=0) {
                tr.setBackgroundColor(getResources().getColor(R.color.SteelBlue));
            }
            else {
                tr.setBackgroundColor(getResources().getColor(R.color.WhiteSmoke));
            }
            // tr.setId(100+count);
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

//Create two columns to add as table data
            // Create a TextView to add date
            TextView labelDATE = new TextView(this);
            //  labelDATE.setId(200+count);
//        labelDATE.setText(responseList.get(0).getBenefList().get(i).getOrgTransRefNum());
            labelDATE.setText(detailList.get(i).getOrderDate());
            labelDATE.setPadding(5, 0, 0, 0);
            labelDATE.setTextColor(Color.BLACK);
            labelDATE.setGravity(View.TEXT_ALIGNMENT_CENTER);
            tr.addView(labelDATE);

            TextView labelWEIGHT = new TextView(this);
            //  labelWEIGHT.setId(200+count);
            // labelWEIGHT.setText(responseList.get(0).getBenefList().get(i).getUTRNo());
            labelWEIGHT.setText(detailList.get(i).getVcrSubject());
            labelWEIGHT.setPadding(0, 0, 0, 0);
            labelWEIGHT.setTextColor(Color.BLACK);
            labelWEIGHT.setGravity(View.TEXT_ALIGNMENT_CENTER);

            tr.addView(labelWEIGHT);


            TextView labelWEIGHT1 = new TextView(this);
            //  labelWEIGHT1.setId(200+count);
            labelWEIGHT1.setText(String.valueOf(detailList.get(i).getNumActualFees()));
            labelWEIGHT1.setPadding(0, 0, 40, 0);
            labelWEIGHT1.setTextColor(Color.BLACK);
            labelWEIGHT1.setGravity(View.TEXT_ALIGNMENT_CENTER);

        tr.addView(labelWEIGHT1);


        TextView labelWEIGHT2 = new TextView(this);
        //   labelWEIGHT2.setId(200+count);
        //      labelWEIGHT2.setText(String.valueOf(responseList.get(0).getBenefList().get(i).getTotalAmount()));
        labelWEIGHT2.setText("Pending");
        labelWEIGHT2.setTextColor(Color.BLACK);
        labelWEIGHT2.setPadding(0, 0, 20, 0);
        labelWEIGHT2.setGravity(View.TEXT_ALIGNMENT_CENTER);

        tr.addView(labelWEIGHT2);


// finally add this to the table row
        t2.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

    }



    }

    @Override
    public void showListSuccessMsg(List<GPlist> data) {

    }

    @Override
    public void showFLoginSuccessMsg(String success) {

        Toast.makeText(context,"No record",Toast.LENGTH_LONG).show();

    }

    @Override
    public void showPaySuccessMsg(String success) {

    }

    @Override
    public void showprogress() {

        progressDialog.show();
    }

    @Override
    public void hideprogress() {

        progressDialog.dismiss();
    }


    /*private void datatab(){


        TableRow tr = new TableRow(this);
        tr.setMinimumHeight(70);


               if(i%2!=0) {
                    tr.setBackgroundColor(getResources().getColor(R.color.SteelBlue));
                }
                else {
                    tr.setBackgroundColor(getResources().getColor(R.color.WhiteSmoke));
                }
        // tr.setId(100+count);
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

//Create two columns to add as table data
        // Create a TextView to add date
        TextView labelDATE = new TextView(this);
        //  labelDATE.setId(200+count);
//        labelDATE.setText(responseList.get(0).getBenefList().get(i).getOrgTransRefNum());
         labelDATE.setText("25/07/2018");
        labelDATE.setPadding(5, 0, 0, 0);
        labelDATE.setTextColor(Color.BLACK);
        labelDATE.setGravity(View.TEXT_ALIGNMENT_CENTER);
        tr.addView(labelDATE);

        TextView labelWEIGHT = new TextView(this);
        //  labelWEIGHT.setId(200+count);
       // labelWEIGHT.setText(responseList.get(0).getBenefList().get(i).getUTRNo());
        labelWEIGHT.setText("Engineering");
        labelWEIGHT.setPadding(0, 0, 40, 0);

        labelWEIGHT.setTextColor(Color.BLACK);
        labelWEIGHT.setGravity(View.TEXT_ALIGNMENT_CENTER);

        tr.addView(labelWEIGHT);


        TextView labelWEIGHT1 = new TextView(this);
        //  labelWEIGHT1.setId(200+count);
         labelWEIGHT1.setText("1500");
        labelWEIGHT1.setPadding(0, 0, 40, 0);
        labelWEIGHT1.setTextColor(Color.BLACK);
        labelWEIGHT1.setGravity(View.TEXT_ALIGNMENT_CENTER);

        *//*if(responseList.get(0).getBenefList().get(i).getSuccess() == 1){

            labelWEIGHT1.setText("Success");
        }
        else if(responseList.get(0).getBenefList().get(i).getPending() == 1){

            labelWEIGHT1.setText("Pending");

        }
        else if(responseList.get(0).getBenefList().get(i).getFailed() == 1){

            labelWEIGHT1.setText("Failed");

        }
*//*
        tr.addView(labelWEIGHT1);


        TextView labelWEIGHT2 = new TextView(this);
        //   labelWEIGHT2.setId(200+count);
  //      labelWEIGHT2.setText(String.valueOf(responseList.get(0).getBenefList().get(i).getTotalAmount()));
          labelWEIGHT2.setText("Pending");
         labelWEIGHT2.setTextColor(Color.BLACK);
        labelWEIGHT2.setPadding(0, 0, 10, 0);
        labelWEIGHT2.setGravity(View.TEXT_ALIGNMENT_CENTER);

        tr.addView(labelWEIGHT2);


// finally add this to the table row
        t2.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));



    }*/

}
