package com.example.xakr.uta_ubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class buypage extends AppCompatActivity {

    GridView gridView;
    buyAdapter adapter;
    DBHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buypage);

        gridView=(GridView) findViewById(R.id.gridView);
        myDb = DBHelper.getInstance(this.getApplicationContext());
        adapter=new buyAdapter(buypage.this,myDb.returnItem());
        gridView.setAdapter(adapter);
    }
}
