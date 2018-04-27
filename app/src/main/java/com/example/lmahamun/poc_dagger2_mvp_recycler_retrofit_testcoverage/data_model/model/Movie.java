package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Mahavir on 4/12/2016.
 */

public class Movie implements Parcelable {
    public static final String INTENT_MOVIE = "Movie";


    @SerializedName("poster_path")
    String posterPath;

    @SerializedName("adult")
    String adult;

    @SerializedName("overview")
    String overview;

    @SerializedName("release_date")
    String releaseDate;

    @SerializedName("id")
    String id;

    @SerializedName("original_title")
    String originalTitle;

    @SerializedName("original_language")
    String originalLanguage;

    @SerializedName("title")
    String title;

    @SerializedName("backdrop_path")
    String backdropPath;

    @SerializedName("popularity")
    float popularity;

    @SerializedName("vote_count")
    int voteCount;

    @SerializedName("vote_average")
    float voteAverage;

    public Movie() {
    }

    protected Movie(Parcel in) {
        readFromParcel(in);
    }

    public Movie(String posterPath, String adult, String overview,
                 String releaseDate, String id, String originalTitle, String title,
                 String backdropPath, float popularity, int voteCount,
                 float voteAverage) {
        this.posterPath = posterPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.id = id;
        this.originalTitle = originalTitle;
        this.title = title;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getFormattedReleaseDate() {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date date = simpleDateFormat1.parse(releaseDate);
            releaseDate = simpleDateFormat2.format(date);
        } catch (ParseException e) {
            Log.e("Movie", "Exception => " + e.getLocalizedMessage());
        }
        return releaseDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    private void readFromParcel(Parcel in) {
        posterPath = in.readString();
        adult = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        id = in.readString();
        originalTitle = in.readString();
        originalLanguage = in.readString();
        title = in.readString();
        backdropPath = in.readString();
        popularity = in.readFloat();
        voteCount = in.readInt();
        voteAverage = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(posterPath);
        dest.writeString(adult);
        dest.writeString(overview);
        dest.writeString(releaseDate);
        dest.writeString(id);
        dest.writeString(originalTitle);
        dest.writeString(originalLanguage);
        dest.writeString(title);
        dest.writeString(backdropPath);
        dest.writeFloat(popularity);
        dest.writeInt(voteCount);
        dest.writeFloat(voteAverage);
    }
}
