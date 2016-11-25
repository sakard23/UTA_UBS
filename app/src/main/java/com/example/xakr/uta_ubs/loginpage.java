package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import static android.R.attr.onClick;
import static com.example.xakr.uta_ubs.R.id.textView;

public class loginpage extends AppCompatActivity {
    //DBHelper myDb;
    TextView textview;
    //dbManager myDb=new dbManager(this,null,null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        textview = (TextView) findViewById(R.id.textView5);
        //myDb = new DBHelper (this);

        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String user = "user";
                String pass = "pass";
                logIn(v, user, pass);
            }
        });


    }

    public void forgotPassword(View view){
        Intent intent = new Intent(this,securitypage.class);
        startActivity(intent);
    }

    public void registerUser(View view){
        Intent intent=new Intent(this, registerpage.class);
        startActivity(intent);
    }
    public void logIn(View view, String username, String password){
        Intent startWCIntent = new Intent(getApplicationContext(), wcpage.class);
        startActivity(startWCIntent);
    }



}