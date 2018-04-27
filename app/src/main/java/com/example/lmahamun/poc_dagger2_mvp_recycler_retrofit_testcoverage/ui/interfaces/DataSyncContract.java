package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.interfaces;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model.Movie;

import java.util.List;

public class DataSyncContract {

    public interface View {
        void showRecords(int count, String records);
    }

    public interface Actions {
        void getFirstFeeds();

        void getNextFeeds();
    }
}