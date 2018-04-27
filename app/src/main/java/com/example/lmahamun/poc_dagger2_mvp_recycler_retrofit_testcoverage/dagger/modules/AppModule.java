package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.dagger.modules;

import android.content.Context;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ProntoShopApplication;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.retrofit.ApiInterface;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.retrofit.InitRetrofit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Laxmikant Mahamuni on 22-03-2018.
 */

@Module
public class AppModule {
    private final ProntoShopApplication mApplication;

    public AppModule(ProntoShopApplication prontoShopApplication) {
        this.mApplication = prontoShopApplication;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return mApplication;
    }


    @Singleton
    @Provides
    public Retrofit provideRetrofit() {
        return InitRetrofit.getRetrofit(mApplication);
    }

    @Provides
    @Singleton
    public ApiInterface provideApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }
}
