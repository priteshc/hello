package com.example.hp.ekeeda_vendor.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hp.ekeeda_vendor.R;


/**
 * Created by pritesh on 5/24/2017.
 */

public class Admin_Holder extends RecyclerView.ViewHolder {

    public TextView date,time,subject,univercity,stream,sem,status;
    public LinearLayout continer;
    public ImageView remove;


    public Admin_Holder(View itemView) {
        super(itemView);

        date = (TextView) itemView.findViewById(R.id.txtDate);
        time = (TextView) itemView.findViewById(R.id.time);
        subject = (TextView) itemView.findViewById(R.id.subject);
        univercity = (TextView) itemView.findViewById(R.id.univercity);
        stream = (TextView) itemView.findViewById(R.id.stream);
        sem = (TextView) itemView.findViewById(R.id.sem);
        status = (TextView) itemView.findViewById(R.id.satus);

       // remove = itemView.findViewById(R.id.remove);

      //  continer = itemView.findViewById(R.id.container);

    }
}
