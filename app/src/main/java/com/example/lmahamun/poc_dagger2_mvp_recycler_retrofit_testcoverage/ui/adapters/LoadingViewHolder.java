package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.R;

/**
 * Created by hardmeht on 21-03-2018.
 */

class LoadingViewHolder extends RecyclerView.ViewHolder {
    public ProgressBar progressBar;
    public LoadingViewHolder(View itemView) {
        super(itemView);
        progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);
    }
}