package com.example.xakr.uta_ubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        String s=getIntent().getStringExtra("EXTRA");
        gridView=(GridView) findViewById(R.id.gridView);
        myDb = DBHelper.getInstance(this.getApplicationContext());
        if(s==null)
            adapter=new buyAdapter(buypage.this,myDb.returnItem());
        else{
            ArrayList<Item> items=myDb.returnItem();
            ArrayList<Item> searchedItems=new ArrayList<Item>();
            for(int i=0;i<items.size();i++){
                Item a=items.get(i);
                if(a.getItname().equals(s) || (a.getPrice().equals(s))|| (a.getDetails().equals(s))||
                        (a.getEid().equals(s))){
                    searchedItems.add(a);
                }
            }
            adapter=new buyAdapter(buypage.this,searchedItems);
        }
        gridView.setAdapter(adapter);
    }
}
