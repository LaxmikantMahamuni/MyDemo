package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.DataManager;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model.Movie;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.retrofit.ApiInterface;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.interfaces.ProductListContract;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ProntoShopApplication;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by Laxmikant Mahamuni on 22-03-2018.
 */

public class ProductListPresenter implements ProductListContract.Actions {
    private final ProductListContract.View mView;

    @Inject
    DataManager mDataManager;

    private Subscription mSubscription;


    public ProductListPresenter(ProductListContract.View mView) {
        this.mView = mView;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }

    public void getConfigurationAndLoadMovies() {

        mSubscription = mDataManager.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new APIResponseMapper())
                .subscribe(new Subscriber<List<Movie>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getAppsError", e.getMessage());
                        //raise Toast, play sound, etc
                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        mView.showProducts(movies);
                    }
                });
    }

    @Override
    public void onButtonClick() {
        mView.moveToNextActivity();
    }


    /**
     * Class that caches API response
     */
    class APIResponseMapper implements Func1<ApiInterface.Response.MovieResponse, List<Movie>> {

        @Override
        public List<Movie> call(ApiInterface.Response.MovieResponse movieResponse) {
            List<Movie> list = movieResponse.getResults();

            return list;
        }
    }
}
