package com.example.heterogenouslayoutpractice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    private ArrayList<Object> mObjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        for (int i = 0; i<5; i++){
            String title = ""+i;
            mObjects.add(title);

        }

        for (int i = 25; i >= 0; i--){
            int j = i%5;
            Things thing = new Things(""+j, "0.00"+i, "02/01/2019");
            mObjects.add(thing);
        }

        //for (int i = 0; i<5; i++){

        //}
        //attempting to override collections sort method

        Collections.sort(mObjects, new Comparator<Object>() {
            @Override
            public int compare(Object a, Object b){
                if (a instanceof String && b instanceof Things){
                    //compare string title with thing object
                    String name = ((Things) b).getmName();
                    String title = ((String) a);
                    return name.compareTo(title);
                } else if (b instanceof String && a instanceof Things){
                    //compare string title with thing object
                    String name = ((Things) a).getmName();
                    String title = ((String) b);
                    return name.compareTo(title);
                } else if (a instanceof Things && b instanceof Things){
                    //compare two same objects from things class
                    int compared = ((Things) a).getmName().compareTo(((Things) b).getmName());
                    //if two strings are equal use a sub category for compare
                    if (compared == 0){
                        String totalA = ((Things) a).getmCost();
                        String totalB = ((Things) b).getmCost();
                        return totalA.compareTo(totalB);
                    }
                    return compared;
                } else if (a instanceof String && b instanceof String){
                    //compare two string titles
                    return ((String) a).compareTo((String) b);
                }
                return 0;
            }
        });



        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(this, mObjects);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
