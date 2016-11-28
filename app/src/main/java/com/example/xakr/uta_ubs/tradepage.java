package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class tradepage extends AppCompatActivity {

    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tradepage);

        Button sell = (Button) findViewById(R.id.button5);
        sell.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), sellpage.class);
                startActivity(i);
            }

        });

        Button buy = (Button) findViewById(R.id.button6);
        buy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), buypage.class);
                startActivity(i);
            }


        });

        Button done=(Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                EditText search=(EditText) findViewById(R.id.searchItem);
                String keyword=search.getText().toString();
                Intent i = new Intent(getApplicationContext(), buypage.class);
                i.putExtra("EXTRA",keyword);
                startActivity(i);
            }


        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }
}
