package com.example.helloworld.RoomData.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    int id;
    String reminder_time;
    String max_distance;
    String gender;
    String acc_privacy;
    String age_range;

    @Ignore
    public Person(String reminder_time, String max_distance, String gender, String acc_privacy, String age_range) {
        this.reminder_time = reminder_time;
        this.max_distance = max_distance;
        this.gender = gender;
        this.acc_privacy = acc_privacy;
        this.age_range = age_range;
    }

    public Person(int id, String reminder_time, String max_distance, String gender, String acc_privacy, String age_range) {
        this.id = id;
        this.reminder_time = reminder_time;
        this.max_distance = max_distance;
        this.gender = gender;
        this.acc_privacy = acc_privacy;
        this.age_range = age_range;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReminder_time() {
        return reminder_time;
    }

    public void setReminder_time(String reminder_time) {
        this.reminder_time = reminder_time;
    }

    public String getMax_distance() {
        return max_distance;
    }

    public void setMax_distance(String max_distance) {
        this.max_distance = max_distance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAcc_privacy() {
        return acc_privacy;
    }

    public void setAcc_privacy(String acc_privacy) {
        this.acc_privacy = acc_privacy;
    }

    public String getAge_range() {
        return age_range;
    }

    public void setAge_range(String age_range) {
        this.age_range = age_range;
    }
}
