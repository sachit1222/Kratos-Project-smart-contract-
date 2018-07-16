package com.example.sachit.sachitsauctionapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ApplicationInterface extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_interface);


        firebaseAuth = FirebaseAuth.getInstance();

        final Button logout = (Button) findViewById(R.id.btnLogout);
        search = (Button) findViewById(R.id.btnSearch);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent registerIntent = new Intent(ApplicationInterface.this, LoginActivity.class);
                ApplicationInterface.this.startActivity(registerIntent);
                firebaseAuth.signOut();
                finish();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(ApplicationInterface.this, SearchActivity.class);
                ApplicationInterface.this.startActivity(registerIntent);
            }
        });



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
