package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class wcpage extends AppCompatActivity {

    EditText keyword;
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
                Intent i = new Intent(getApplicationContext(), tradepage.class);
                startActivity(i);
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
        keyword=(EditText) findViewById(R.id.search);
        Button X=(Button) findViewById(R.id.search_button);
        X.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String s=keyword.getText().toString();
                Intent i = new Intent(getApplicationContext(), searchpage.class);
                i.putExtra("KEY",s);
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
