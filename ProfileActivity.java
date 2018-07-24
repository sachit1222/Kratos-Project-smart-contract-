package com.example.sachit.sachitsauctionapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        EditText etShowEmail = (EditText) findViewById(R.id.etShowEmail);
        email = getIntent().getStringExtra("email");
        etShowEmail.setText(email);

    }

}
