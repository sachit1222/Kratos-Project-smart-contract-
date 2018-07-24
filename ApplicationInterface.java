package com.example.sachit.sachitsauctionapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class ApplicationInterface extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button search;
   String[] buyerSeller = {"Buyer", "Seller"};
   String email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_interface);

        final Spinner spinner = (Spinner) findViewById(R.id.text_Spinner);
        Button button1 = (Button) findViewById(R.id.btnSpinner);
        email = getIntent().getStringExtra("email");


        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.buyerSeller, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
//        MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.text_Spinner);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItemPosition() == 1) {
                    Intent registerIntent = new Intent(ApplicationInterface.this, SearchActivity.class);
                    ApplicationInterface.this.startActivity(registerIntent);
                }
                else if(spinner.getSelectedItemPosition() == 2){
                    Intent registerIntent = new Intent(ApplicationInterface.this, SellerActivity.class);
                    ApplicationInterface.this.startActivity(registerIntent);
                }
                else{
                    Toast.makeText(ApplicationInterface.this, "Select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_search){
            Intent registerIntent = new Intent(ApplicationInterface.this, SearchActivity.class);
            ApplicationInterface.this.startActivity(registerIntent);
            return true;
        }
        else if(item.getItemId() == R.id.action_logout){

            Intent registerIntent = new Intent(ApplicationInterface.this, LoginActivity.class);
            ApplicationInterface.this.startActivity(registerIntent);
            firebaseAuth.signOut();
            finish();
            return true;
        }
        else if(item.getItemId() == R.id.action_profile){
            Bundle bundle = new Bundle();
            bundle.putString("email", email);
            Intent registerIntent = new Intent(ApplicationInterface.this, ProfileActivity.class);
            registerIntent.putExtras(bundle);
            ApplicationInterface.this.startActivity(registerIntent);
            return true;

        }
        else {
            return false;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        if (i == 1) {
            Intent registerIntent = new Intent(ApplicationInterface.this, SearchActivity.class);
            ApplicationInterface.this.startActivity(registerIntent);
        }
        else if(i == 2){
            Intent registerIntent = new Intent(ApplicationInterface.this, SellerActivity.class);
            ApplicationInterface.this.startActivity(registerIntent);
        }
        else{
            Toast.makeText(ApplicationInterface.this, "Select an option", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

    }
}
