package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage;

import android.app.Application;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.dagger.AppComponent;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.dagger.modules.AppModule;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.dagger.DaggerAppComponent;


/**
 * Created by Laxmikant Mahamuni on 22-03-2018.
 */

public class ProntoShopApplication extends Application {

    private static ProntoShopApplication instance = new ProntoShopApplication();
    private static AppComponent appComponent;

    public static ProntoShopApplication getInstance() {
        return instance;
    }

    public AppComponent getAppComponent() {

        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        }
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }
}
