package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.presenter.util;

import android.content.Context;

/**
 * Created by hardmeht on 21-03-2018.
 */

public class Utils {

    public static final String BAT_URL = "https://gw.bookatable.com/mobile/v1/";

    public static String getBatchSize(Context context){
        boolean isFastInternetAvailable  = Connectivity.isConnectedFast(context);
        return isFastInternetAvailable ? "100" : "20";
    }
}
