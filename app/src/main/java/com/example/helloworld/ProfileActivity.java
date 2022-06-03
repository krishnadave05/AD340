package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView tv_name, tv_bio;
    TextView tv_username, tv_email, tv_mobile, tv_occupation, tv_age;
    ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tv_name = findViewById(R.id.tv_name);
        tv_bio = findViewById(R.id.tv_bio);
        tv_username = findViewById(R.id.tv_username);
        tv_email = findViewById(R.id.tv_email);
        tv_mobile = findViewById(R.id.tv_mobile);
        tv_occupation = findViewById(R.id.tv_occupation);
        tv_age = findViewById(R.id.tv_age);
        iv_back = findViewById(R.id.iv_back);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });






        String full_name = getIntent().getExtras().getString("full_name");
        String email_addr = getIntent().getExtras().getString("email_addr");
        String bio = getIntent().getExtras().getString("bio");
        String user_name = getIntent().getExtras().getString("user_name");
        String age = getIntent().getExtras().getString("age");
        String occupation = getIntent().getExtras().getString("occupation");
        String mobile = getIntent().getExtras().getString("mobile");

        tv_name.setText(full_name);
        tv_email.setText(email_addr);
        tv_bio.setText(bio);
        tv_username.setText(user_name);
        tv_age.setText(age+" Years");
        tv_occupation.setText(occupation);
        tv_mobile.setText(mobile);


    }
}