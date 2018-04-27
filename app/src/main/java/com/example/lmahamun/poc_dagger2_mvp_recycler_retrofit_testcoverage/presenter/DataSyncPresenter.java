package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ProntoShopApplication;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.DataManager;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.local.database.RealmTable;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model.BATResponse;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model.Change;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.presenter.util.Utils;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.interfaces.DataSyncContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Laxmikant Mahamuni on 22-03-2018.
 */

public class DataSyncPresenter implements DataSyncContract.Actions {

    private final DataSyncContract.View mView;
    private Context context;
    @Inject
    DataManager mDataManager;

    private Subscription mSubscription;
    private Realm realm;

    public DataSyncPresenter(DataSyncContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }


    private String lastSequence = null, oldSequence;
    private int count = 0;
    private TextView txtCount, txtLastSeq;

    @Override
    public void getFirstFeeds() {
        String batchSize = Utils.getBatchSize(context);

        mSubscription = mDataManager.getFirstFeedsFromAPI(batchSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new APIResponseMapper())
                .subscribe(new Subscriber<ArrayList<RealmTable>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getAppsError", e.getMessage());
                        //raise Toast, play sound, etc
                    }

                    @Override
                    public void onNext(ArrayList<RealmTable> realmTables) {
                        count += realmTables.size();
                        mView.showRecords(count, "");

                        getNextFeeds();
                    }
                });
    }

    @Override
    public void getNextFeeds() {
        String batchSize = Utils.getBatchSize(context);

        mSubscription = mDataManager.getNextFeedsFromAPI(batchSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new APIResponseMapper())
                .subscribe(new Subscriber<ArrayList<RealmTable>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getAppsError", e.getMessage());
                        //raise Toast, play sound, etc
                    }

                    @Override
                    public void onNext(ArrayList<RealmTable> realmTables) {
                        count += realmTables.size();
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Last sequence ");
                        stringBuffer.append(oldSequence);
                        stringBuffer.append("Current sequence ");
                        stringBuffer.append(lastSequence);

                        mView.showRecords(count, stringBuffer.toString());

                        if (realmTables.size() > 0) {
                            getNextFeeds();
                        } else {
                            Toast.makeText(context, "All records have been fetched", Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }

    /**
     * Class that caches API response
     */
    class APIResponseMapper implements Func1<BATResponse, ArrayList<RealmTable>> {

        @Override
        public ArrayList<RealmTable> call(BATResponse batResponse) {
            List<Change> list = batResponse.getChanges();
            oldSequence = lastSequence == null ? "" : lastSequence;
            lastSequence = batResponse.getLastSeq();

            if (batResponse.getPending() == 0L) {
                return new ArrayList<>();
            }
            final ArrayList<RealmTable> realmTables = new ArrayList<>();
            Log.d(this.getClass().getName(), "Map");
            for (final Change change : list) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        String id = change.getId();
                        String name = change.getName();
                        String address = change.getAddress();
                        String country = change.getCountry();
                        RealmTable realmTable = new RealmTable(id, name, address, country);
                        realm.insertOrUpdate(realmTable);
                        realmTables.add(realmTable);
                    }
                });
            }
            return realmTables;
        }
    }
}
