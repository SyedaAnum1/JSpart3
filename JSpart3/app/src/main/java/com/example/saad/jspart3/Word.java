package com.example.saad.jspart3;

/**
 * Created by saad on 12/28/2016.
 */
public class Word {
    private String mTitle;
    private String mCompany;
    private String mCity;
    private String mState;
    private String mCountry;
    private String mformattedLocation;
    private String mSource;
    private String mPostDate;
    private String mSnippet;
    private String mURL;
    private String mLatitude;
    private String mLongitude;
    private String mJobkey;
    private String mSponsored;
    private String mExpired;
    private String mformattedLocationFull;
    private String mformattedRelativeTime;

    public Word(String title,String company, String county, String city, String postDate, String source, String state, String formattedLocation, String snippet, String url, String latitude, String longitude,  String jobkey, String sponsored, String expired, String formattedLocationFull, String formattedRelativeTime ){
        mTitle = title;
        mCompany = company;
        mCountry = county;
        mCity = city;
        mPostDate = postDate;
        mSource = source;
        mState = state;
        mformattedLocation = formattedLocation;
        mSnippet = snippet;
        mURL = url;
        mLatitude = latitude;
        mLongitude = longitude;
        mJobkey = jobkey;
        mSponsored = sponsored;
        mExpired = expired;
        mformattedLocationFull = formattedLocationFull;
        mformattedRelativeTime = formattedRelativeTime;

    }
    public String getmTitle(){
        return mTitle;
    }
    public String getmCountry(){
        return mCountry;
    }
    public String getmCity(){
        return mCity;
    }
    public String getmPostDate(){
        return mPostDate;
    }
    public String getmCompany(){
        return mCompany;
    }
    public String getmSource(){
        return mSource;
    }
    public String getmState(){
        return mState;
    }
    public String getmformattedLocation(){
        return mformattedLocation;
    }
    public String getmSnippet(){
        return mSnippet;
    }
    public String getmURL(){
        return mURL;
    }
    public String getmLatitude(){
        return mLatitude;
    }
    public String getmLongitude(){
        return mLongitude;
    }
    public String getmJobkey(){
        return mJobkey;
    }

    public String getmExpired() {
        return mExpired;
    }

    public String getMformattedLocationFull() {
        return mformattedLocationFull;
    }

    public String getMformattedRelativeTime() {
        return mformattedRelativeTime;
    }

    public String getmSponsored() {
        return mSponsored;
    }
}
