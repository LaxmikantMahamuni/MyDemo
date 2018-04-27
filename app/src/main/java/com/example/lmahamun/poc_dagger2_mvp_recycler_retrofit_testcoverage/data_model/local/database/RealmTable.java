package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.local.database;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by hardmeht on 21-03-2018.
 */

public class RealmTable extends RealmObject {
    @PrimaryKey
    String id;

    String name;
    String address;
    String country;

    public void setLoader(int loader) {
        this.loader = loader;
    }

    public int getLoader() {
        return loader;
    }

    @Ignore
    int loader;

    public RealmTable(){

    }
    public RealmTable(String id, String name, String address, String country) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }
}
