package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.retrofit;

//import com.codetoart.android.upcomingmovieapp.data.local.PreferencesHelper;

import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model.BATResponse;
import com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiInterface {
    String API_KEY = "b7cd3340a794e5a2f35e3abb820b497f";

    String REALM_API_KEY = "UJB9kwr5lz82nrXejCFbM8SSKvn2Uj9a9IU9ib8K";
    String langaugeCode = "en-GB";


    /*@GET("movie/upcoming")
    public Call<MovieResponse> upcomingMovies(@Query("api_key") String apikey);*/
    @GET("movie/upcoming")
    public Observable<Response.MovieResponse> upcomingMovies(@Query("api_key") String apikey);


    @GET("content/summary/changes")
    Observable<BATResponse> getFirstFeeds(@Query("languageCode") String languageCode, @Query("limit") String limit, @Header("x-api-key") String API_KEY);

    @GET("content/summary/changes")
    Observable<BATResponse> getNextFeeds(@Query("languageCode") String languageCode, @Query("limit") String limit, @Query("since") String since, @Header("x-api-key") String API_KEY);


    class Response {
        public static class MovieResponse {
            @SerializedName("page")
            int page;

            @SerializedName("results")
            ArrayList<Movie> results;

            @SerializedName("dates")
            Date dates;

            @SerializedName("total_pages")
            int totalPages;

            @SerializedName("total_results")
            int totalResults;

            public MovieResponse() {
            }

            public int getTotalPages() {
                return totalPages;
            }

            public void setTotalPages(int totalPages) {
                this.totalPages = totalPages;
            }

            public ArrayList<Movie> getResults() {
                return results;
            }

            public void setResults(ArrayList<Movie> movies) {
                this.results = movies;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public Date getDates() {
                return dates;
            }

            public void setDates(Date dates) {
                this.dates = dates;
            }

            public int getTotalResults() {
                return totalResults;
            }

            public void setTotalResults(int totalResults) {
                this.totalResults = totalResults;
            }
        }

        public static class Date {
            String maximum;
            String minimum;

            public Date() {
            }

            public String getMaximum() {
                return maximum;
            }

            public void setMaximum(String maximum) {
                this.maximum = maximum;
            }

            public String getMinimum() {
                return minimum;
            }

            public void setMinimum(String minimum) {
                this.minimum = minimum;
            }
        }

    }
}
