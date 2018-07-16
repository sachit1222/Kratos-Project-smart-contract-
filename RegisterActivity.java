package com.example.sachit.sachitsauctionapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private EditText etPassword, etEmail;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        setUIViews();


//        final EditText name = (EditText) findViewById(R.id.etUsername);
//        final EditText password = (EditText) findViewById(R.id.etPassword1);
//        final EditText email = (EditText) findViewById(R.id.etEmail1);
//        final EditText location = (EditText) findViewById(R.id.etLocation1);
//
//        final Button register = (Button) findViewById(R.id.bxtnRegister);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validate()) {

                    String user_email = etEmail.getText().toString().trim();
                    String user_password = etPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword (user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                        public void onComplete(@NonNull Task<AuthResult> task) {

                            //  Toast.makeText(RegisterActivity.this, "email: " + user_email, Toast.LENGTH_SHORT).show();
                            //   Toast.makeText(RegisterActivity.this, "password: " + user_password, Toast.LENGTH_SHORT).show();

                            if(task.isSuccessful()){

                                Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, ApplicationInterface.class));
                            }
                            else{

                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }

            }
        });



    }


    protected void setUIViews(){


       // etName = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword2);
        etEmail = (EditText) findViewById(R.id.etEmail2);
        //etLocation = (EditText) findViewById(R.id.etLocation1);

        register = (Button) findViewById(R.id.btnRegister);


    }

    private Boolean validate(){
        Boolean result = false;

       // String name = etName.getText().toString();
        String password = etPassword.getText().toString();
        String email = etEmail.getText().toString();
        //String location = etLocation.getText().toString();

        if(password.isEmpty() || email.isEmpty()){

            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();

        }

        else{
            result = true;
        }

        return result;



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
