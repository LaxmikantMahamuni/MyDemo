package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.dagger;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.dagger.modules.AppModule;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.DataManager;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.presenter.DataSyncPresenter;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.MainActivity;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.presenter.ProductListPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Laxmikant Mahamuni on 22-03-2018.
 */

@Singleton
@Component(
        modules = {
                AppModule.class
        }
)

public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(ProductListPresenter presenter);

    void inject(DataSyncPresenter dataSyncPresenter);

    DataManager dataManager();
}
