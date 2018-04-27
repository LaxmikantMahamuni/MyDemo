package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.R;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.adapters.MoviesAdapter;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model.Movie;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.presenter.ProductListPresenter;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.interfaces.OnRecyclerItemClickListener;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.ui.interfaces.ProductListContract;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductListContract.View, OnRecyclerItemClickListener {

    private ProductListContract.Actions mPresenter;

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //Instantiate the Presenter
        mPresenter = new ProductListPresenter(this);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onButtonClick();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //Ask the Presenter to load the list of products
        mPresenter.getConfigurationAndLoadMovies();
    }

    @Override
    public void showProducts(List<Movie> products) {

        mAdapter = new MoviesAdapter(products, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showEmptyText() {

    }

    @Override
    public void hideEmptyText() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void moveToNextActivity() {
        Intent intent = new Intent(MainActivity.this, DatabaseSyncActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(Object object) {
        Toast.makeText(MainActivity.this, "Hi clicked " + ((Movie) object).getTitle(), Toast.LENGTH_SHORT).show();
    }
}
