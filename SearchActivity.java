package com.example.sachit.sachitsauctionapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends AppCompatActivity {


    //   String[] items;
    ArrayList<String> items;
    ListView listView;
    //  EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = (ListView) findViewById(R.id.listView);
        // editText = (EditText)findViewById(R.id.txtsearch);


        items = new ArrayList<>();
        items.add("Basketball");
        items.add("Baseball");
        items.add("Football");
        items.add("Soccerball");
        items.add("Hockey Puck");
        items.add("Tennis Ball");
        items.add("Volleyball");
        items.add("Frisbee");
        items.add("Golf Ball");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = listView.getItemAtPosition(i).toString();
                Toast.makeText(SearchActivity.this, "" + text, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);


        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<String> templist = new ArrayList<>();

                for (String temp : items) {

                    if (temp.toLowerCase().contains(s.toLowerCase())) {
                        templist.add(temp);
                    }
                }
                ArrayAdapter<String>   adapter = new ArrayAdapter<>(SearchActivity.this, android.R.layout.simple_list_item_1, templist);
                listView.setAdapter(adapter);

                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

}



