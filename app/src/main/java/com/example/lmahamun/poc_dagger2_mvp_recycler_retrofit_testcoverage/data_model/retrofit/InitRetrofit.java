package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.retrofit;

import android.content.Context;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by IBM on 10-Jun-17.
 */

public class InitRetrofit {
    //    public static String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String BASE_URL = "https://gw.bookatable.com/mobile/v1/";

    private static Gson gson;
    String url = "https://gw.bookatable.com/mobile/v1/content/summary/changes?languageCode=en-GB&limit=10&since=39527-g1AAAAJ7eJyd0EsKwjAQBuBBBd1aD6B7N22SPrKyN9GkUUKJdqGu9QReQW_hwoXeRPEWglDTpNBNEdrNDMzwfzCjAGAguwKGSbZPpOCxyhKmZLbdKb3qMODjPM9T2eUAo9Naz_ocJwIjXJf5I_GJrnxWYUuDEYTEigRNsbjA5hV2M5iHfY402BBbFNihwqYGo9gPQk80xDY9XeGom_bOFnQ-BsQkDDw3agVeLHgvwbcBI0KFF_mtwIcFn-XJXwP6AWIkpK3AlwXLHzpXC4aMUuHWRdMftv7EVw";


    public static Retrofit getRetrofit(Context context) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .retryOnConnectionFailure(true)
                .build();


        gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InitRetrofit.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
