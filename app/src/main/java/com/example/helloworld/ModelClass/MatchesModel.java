package com.example.helloworld.ModelClass;

import android.widget.ImageView;

import com.example.helloworld.R;

public class MatchesModel {

    String title;
    String banner_image_url;
    String uid;
    String liked;
    String latitude;
    String longitude;

    public MatchesModel(String title, String banner_image_url, String uid, String liked, String latitude, String longitude) {
        this.title = title;
        this.banner_image_url = banner_image_url;
        this.uid = uid;
        this.liked = liked;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner_image_url() {
        return banner_image_url;
    }

    public void setBanner_image_url(String banner_image_url) {
        this.banner_image_url = banner_image_url;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLiked() {
        return liked;
    }

    public void setLiked(String liked) {
        this.liked = liked;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
