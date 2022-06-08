package com.example.helloworld.ModelClass;

import android.widget.ImageView;

import com.example.helloworld.R;

public class MatchesModel {

    int profile_image;
    String title;
    String sec_title;
    int banner_image;
    String desc;

    public MatchesModel(int profile_image, String title, String sec_title, int banner_image, String desc) {
        this.profile_image = profile_image;
        this.title = title;
        this.sec_title = sec_title;
        this.banner_image = banner_image;
        this.desc = desc;
    }

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSec_title() {
        return sec_title;
    }

    public void setSec_title(String sec_title) {
        this.sec_title = sec_title;
    }

    public int getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(int banner_image) {
        this.banner_image = banner_image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
