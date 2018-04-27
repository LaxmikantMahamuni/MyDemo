package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.R;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.presenter.DataSyncPresenter;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.presenter.ProductListPresenter;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.interfaces.DataSyncContract;

public class DatabaseSyncActivity extends AppCompatActivity implements DataSyncContract.View {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private TextView txtCount, txtLastSeq;
    private DataSyncPresenter dataSyncPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_sync);

        //Instantiate the Presenter
        dataSyncPresenter = new DataSyncPresenter(this, this);

        recyclerView = findViewById(R.id.recyclerview);
        txtCount = findViewById(R.id.txt_count);
        txtLastSeq = findViewById(R.id.txt_last_seq);

        dataSyncPresenter.getFirstFeeds();
    }

    @Override
    public void showRecords(int count, String records) {
        txtCount.setText("Entries count : " + count);

        txtLastSeq.setText(records);
    }
}
