package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class wcpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wcpage);

        Button T =(Button)findViewById(R.id.button4);
        T.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent clubpageIntent=new Intent(getApplicationContext(),clubpage.class);
                startActivity(clubpageIntent);
            }
        });

        Button U = (Button) findViewById(R.id.button7);
        U.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent tradePageIntent = new Intent(getApplicationContext(), tradepage.class);
                startActivity(tradePageIntent);
            }
        });
        Button V = (Button) findViewById(R.id.button8);
        V.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), postpage.class);
                startActivity(i);
            }
        });
        Button W = (Button) findViewById(R.id.button9);
        W.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), emailpage.class);
                startActivity(i);
            }
        });


    }

}
