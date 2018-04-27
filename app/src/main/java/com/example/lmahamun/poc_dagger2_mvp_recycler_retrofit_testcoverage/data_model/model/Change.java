
package com.example.lmahamun.poc_dagger2_mvp_recycler_retrofit_testcoverage.data_model.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Change {

    @SerializedName("address")
    private String mAddress;
    @SerializedName("avgMain")
    private Object mAvgMain;
    @SerializedName("avgMealSpend")
    private Object mAvgMealSpend;
    @SerializedName("avgRating")
    private Long mAvgRating;
    @SerializedName("bookable")
    private Boolean mBookable;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("cuisine")
    private String mCuisine;
    @SerializedName("cuisineIds")
    private List<Object> mCuisineIds;
    @SerializedName("id")
    private String mId;
    @SerializedName("idForBooking")
    private String mIdForBooking;
    @SerializedName("imageName")
    private Object mImageName;
    @SerializedName("latitude")
    private Double mLatitude;
    @SerializedName("longitude")
    private Double mLongitude;
    @SerializedName("maxPrice")
    private Object mMaxPrice;
    @SerializedName("minPrice")
    private Object mMinPrice;
    @SerializedName("name")
    private String mName;
    @SerializedName("offersCount")
    private Long mOffersCount;
    @SerializedName("rev")
    private String mRev;
    @SerializedName("reviewsCount")
    private Long mReviewsCount;
    @SerializedName("seq")
    private String mSeq;
    @SerializedName("starDealsCount")
    private Long mStarDealsCount;

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public Object getAvgMain() {
        return mAvgMain;
    }

    public void setAvgMain(Object avgMain) {
        mAvgMain = avgMain;
    }

    public Object getAvgMealSpend() {
        return mAvgMealSpend;
    }

    public void setAvgMealSpend(Object avgMealSpend) {
        mAvgMealSpend = avgMealSpend;
    }

    public Long getAvgRating() {
        return mAvgRating;
    }

    public void setAvgRating(Long avgRating) {
        mAvgRating = avgRating;
    }

    public Boolean getBookable() {
        return mBookable;
    }

    public void setBookable(Boolean bookable) {
        mBookable = bookable;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getCuisine() {
        return mCuisine;
    }

    public void setCuisine(String cuisine) {
        mCuisine = cuisine;
    }

    public List<Object> getCuisineIds() {
        return mCuisineIds;
    }

    public void setCuisineIds(List<Object> cuisineIds) {
        mCuisineIds = cuisineIds;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getIdForBooking() {
        return mIdForBooking;
    }

    public void setIdForBooking(String idForBooking) {
        mIdForBooking = idForBooking;
    }

    public Object getImageName() {
        return mImageName;
    }

    public void setImageName(Object imageName) {
        mImageName = imageName;
    }

    public Double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(Double latitude) {
        mLatitude = latitude;
    }

    public Double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(Double longitude) {
        mLongitude = longitude;
    }

    public Object getMaxPrice() {
        return mMaxPrice;
    }

    public void setMaxPrice(Object maxPrice) {
        mMaxPrice = maxPrice;
    }

    public Object getMinPrice() {
        return mMinPrice;
    }

    public void setMinPrice(Object minPrice) {
        mMinPrice = minPrice;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getOffersCount() {
        return mOffersCount;
    }

    public void setOffersCount(Long offersCount) {
        mOffersCount = offersCount;
    }

    public String getRev() {
        return mRev;
    }

    public void setRev(String rev) {
        mRev = rev;
    }

    public Long getReviewsCount() {
        return mReviewsCount;
    }

    public void setReviewsCount(Long reviewsCount) {
        mReviewsCount = reviewsCount;
    }

    public String getSeq() {
        return mSeq;
    }

    public void setSeq(String seq) {
        mSeq = seq;
    }

    public Long getStarDealsCount() {
        return mStarDealsCount;
    }

    public void setStarDealsCount(Long starDealsCount) {
        mStarDealsCount = starDealsCount;
    }

}
