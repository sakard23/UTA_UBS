package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class clubpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubpage);

        Button T=(Button)findViewById(R.id.button);
        T.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(getApplicationContext(),joinclub.class);
                startActivity(i);
            }
            /*public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent j=new Intent(getApplicationContext(),createclub.class);
                startActivity(j);
            }*/
        });
    }
}
