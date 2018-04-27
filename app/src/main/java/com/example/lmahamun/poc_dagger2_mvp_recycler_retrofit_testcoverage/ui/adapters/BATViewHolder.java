package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.R;

/**
 * Created by hardmeht on 21-03-2018.
 */

public class BATViewHolder extends RecyclerView.ViewHolder {

    AppCompatTextView txtName, txtAddress, txtCountry;

    public BATViewHolder(View itemView) {
        super(itemView);
        if (itemView == null)
            return;
        txtName = itemView.findViewById(R.id.txt_name);
        txtAddress = itemView.findViewById(R.id.txt_address);
        txtCountry = itemView.findViewById(R.id.txt_country);
    }
}
