package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.interfaces;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model.Movie;

import java.util.List;

public class ProductListContract {

    public interface View {
        void showProducts(List<Movie> products);

        void showEmptyText();

        void hideEmptyText();

        void showMessage(String message);

        void moveToNextActivity();
    }

    public interface Actions {
        void getConfigurationAndLoadMovies();

        void onButtonClick();
    }
}