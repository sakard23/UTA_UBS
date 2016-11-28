package com.example.xakr.uta_ubs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by Sushil on 11/28/2016.
 */

public class selectIndiv extends AppCompatActivity {

    ListView listView;
    indivAdapter adapter;
    DBHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_indiv);

        listView=(ListView) findViewById(R.id.listViewEmail);
        myDb = DBHelper.getInstance(this.getApplicationContext());
        adapter=new indivAdapter(selectIndiv.this,myDb.returnUser());
        listView.setAdapter(adapter);
    }
}
