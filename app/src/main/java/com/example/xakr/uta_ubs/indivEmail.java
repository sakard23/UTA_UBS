package com.example.xakr.uta_ubs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import static com.example.xakr.uta_ubs.R.id.listView;

/**
 * Created by Sushil on 11/28/2016.
 */

public class indivEmail extends AppCompatActivity {
    ListView listView;
    DBHelper myDb;
    indivEmailAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indivlistview);

        listView=(ListView) findViewById(R.id.indivListView);
        myDb = DBHelper.getInstance(this.getApplicationContext());
        adapter=new indivEmailAdapter(indivEmail.this,myDb.returnUser());
        listView.setAdapter(adapter);
    }//kj
}
