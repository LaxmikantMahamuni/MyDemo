package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model.BATResponse;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.retrofit.ApiInterface;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by Laxmikant Mahamuni on 26-03-2018.
 */

@Singleton
public class DataManager {

    private final ApiInterface apiInterface;
    private String lastSequence = null, oldSequence;

    @Inject
    public DataManager(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }


    public Observable<ApiInterface.Response.MovieResponse> getMovies() {
        return apiInterface.upcomingMovies(ApiInterface.API_KEY)
                .doOnNext(new Action1<ApiInterface.Response.MovieResponse>() {
                    @Override
                    public void call(ApiInterface.Response.MovieResponse movieResponse) {
                    }
                })
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ApiInterface.Response.MovieResponse>>() {
                    @Override
                    public Observable<? extends ApiInterface.Response.MovieResponse> call(Throwable throwable) {
                        return null;
                    }
                });
    }


    public Observable<BATResponse> getFirstFeedsFromAPI(String batchSize) {
        return apiInterface.getFirstFeeds(ApiInterface.langaugeCode, batchSize, ApiInterface.REALM_API_KEY)
                .doOnNext(new Action1<BATResponse>() {
                    @Override
                    public void call(BATResponse batResponse) {
                    }
                })
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends BATResponse>>() {
                    @Override
                    public Observable<? extends BATResponse> call(Throwable throwable) {
                        return null;
                    }
                });
    }

    public Observable<BATResponse> getNextFeedsFromAPI(String batchSize) {
        return apiInterface.getNextFeeds(ApiInterface.langaugeCode, batchSize, lastSequence, ApiInterface.REALM_API_KEY)
                .doOnNext(new Action1<BATResponse>() {
                    @Override
                    public void call(BATResponse batResponse) {
                    }
                })
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends BATResponse>>() {
                    @Override
                    public Observable<? extends BATResponse> call(Throwable throwable) {
                        return null;
                    }
                });
    }
}
