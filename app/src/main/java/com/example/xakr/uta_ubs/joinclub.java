package com.example.xakr.uta_ubs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class joinclub extends AppCompatActivity {
    ListView listView;
    clubAdapter adapter;
    DBHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joinclub);

        listView=(ListView) findViewById(R.id.listView);
        myDb = DBHelper.getInstance(this.getApplicationContext());
        adapter=new clubAdapter(joinclub.this,myDb.returnClub());
        listView.setAdapter(adapter);
    }
}
