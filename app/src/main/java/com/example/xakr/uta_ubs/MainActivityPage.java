package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivityPage extends AppCompatActivity {

    private static Button join_club;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        //onClickButtonListener();
    }
/*
    public void onClickButtonListener()
    {
        join_club = (Button) findViewById(R.id.button);
        join_club.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent("com.example.xakr.uta_ubs.clubpage");
                        startActivity(intent);
                    }

                    }

        );

    }*/


    public void clubpage(View view) {
        Intent intent = new Intent (this, clubpage.class);
        startActivity(intent);
    }
    }
