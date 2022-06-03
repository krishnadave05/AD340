package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_full_name, et_email_addr, et_bio, et_user_name, et_age, et_occupation, et_mobile;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_full_name = findViewById(R.id.et_full_name);
        et_email_addr = findViewById(R.id.et_email_addr);
        et_bio = findViewById(R.id.et_bio);
        et_user_name = findViewById(R.id.et_user_name);
        et_age = findViewById(R.id.et_age);
        et_occupation = findViewById(R.id.et_occupation);
        et_mobile = findViewById(R.id.et_mobile);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_full_name.getText().toString().isEmpty() ||
                        et_email_addr.getText().toString().isEmpty() ||
                        et_bio.getText().toString().isEmpty() ||
                        et_user_name.getText().toString().isEmpty() ||
                        et_age.getText().toString().isEmpty() ||
                        et_occupation.getText().toString().isEmpty() ||
                        et_mobile.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all the details!", Toast.LENGTH_SHORT).show();
                }
                else {
                 
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtra("full_name", et_full_name.getText().toString());
                    intent.putExtra("email_addr", et_email_addr.getText().toString());
                    intent.putExtra("bio", et_bio.getText().toString());
                    intent.putExtra("user_name", et_user_name.getText().toString());
                    intent.putExtra("age", et_age.getText().toString());
                    intent.putExtra("occupation", et_occupation.getText().toString());
                    intent.putExtra("mobile", et_mobile.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }
}