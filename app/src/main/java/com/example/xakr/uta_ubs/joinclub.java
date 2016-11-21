package com.example.xakr.uta_ubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class joinclub extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ListView listview;
    /*String[] android = {"charie",
            "go",
            "to",
            "sleep"};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joinclub);
        /*listview = (ListView) findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android);
        listview.setAdapter(adapter);*/
    }
}
