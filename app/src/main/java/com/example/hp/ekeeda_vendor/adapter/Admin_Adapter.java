package com.example.hp.ekeeda_vendor.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.ekeeda_vendor.R;
import com.example.hp.ekeeda_vendor.holder.Admin_Holder;
import com.example.hp.ekeeda_vendor.model.Detail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pritesh on 5/24/2017.
 */

public class Admin_Adapter extends RecyclerView.Adapter<Admin_Holder> {

    Context mContext;
    List<Detail> purchaseListPojos = new ArrayList<>();

    //private RemoveCall removeCall;

    private int lastPosition = -1;
    private SimpleDateFormat mSDFOld,mSDRtime;



    public Admin_Adapter(Context c) {

        mContext = c;


      //  this.removeCall = removeCall;

    }


    public void SetList(List<Detail> purchaseListPojos){

  //      purchaseListPojos.clear();

        this.purchaseListPojos = purchaseListPojos;

        notifyDataSetChanged();

    }

    @Override
    public Admin_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recordview, parent, false);

        return new Admin_Holder(itemView);
    }

    @Override
    public void onBindViewHolder(Admin_Holder holder, final int position) {

        final Detail list = purchaseListPojos.get(position);

        holder.date.setText(list.getOrderDate());
        holder.time.setText(list.getTime());
        holder.subject.setText(list.getVcrSubject());
        holder.sem.setText(list.getVcrSemester());
        holder.stream.setText(list.getVcrStream());
        holder.status.setText(list.getVcrStatus());

     /*   holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                removeCall.onMethodCallback(list.getPurchaseId(), String.valueOf(position));
           //     Toast.makeText(mContext,list.getPurchaseId(),Toast.LENGTH_SHORT).show();
            }
        });*/



    }



    @Override
    public int getItemCount() {
        return purchaseListPojos.size();
    }
}
