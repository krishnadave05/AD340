package com.example.helloworld.ModelClass;

import android.widget.ImageView;

import com.example.helloworld.R;

public class MatchesModel {

    String title;
    String banner_image_url;
    String uid;
    String liked;

    public MatchesModel(String title, String banner_image_url, String uid, String liked) {
        this.title = title;
        this.banner_image_url = banner_image_url;
        this.uid = uid;
        this.liked = liked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBanner_image() {
        return banner_image_url;
    }

    public void setBanner_image(String banner_image_url) {
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
}
