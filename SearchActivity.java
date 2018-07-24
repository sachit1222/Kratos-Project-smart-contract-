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
    EditText editText;
    private ArrayList<String> filterData;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText)findViewById(R.id.type_search);


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

        filterData = new ArrayList<>();
        filterData.addAll(items);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filterData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = listView.getItemAtPosition(i).toString();
                Toast.makeText(SearchActivity.this, "" + text, Toast.LENGTH_SHORT).show();
            }
        });


        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                search(s.toString());


            }
        });
    }

    private void search(String s) {

        if(s.trim().length() == 0){
            filterData.clear();
            filterData.addAll(items);
            adapter.notifyDataSetChanged();
        }
        else{
            filterData.clear();
            for(String value: items){
                if(value.toLowerCase().contains(s.trim().toLowerCase())){
                    filterData.add(value);
                }

            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

}



