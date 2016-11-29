package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import static android.R.attr.onClick;


public class loginpage extends AppCompatActivity {
    DBHelper myDb;
    EditText txtusername;
    EditText txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        myDb = DBHelper.getInstance(this.getApplicationContext());
    }

    public void forgotPassword(View view){
        Intent intent = new Intent(this,securitypage.class);
        startActivity(intent);
    }

    public void registerUser(View view){
        Intent intent=new Intent(this, registerpage.class);
        startActivity(intent);
    }
    public void logIn(View view){
        txtusername=(EditText)findViewById(R.id.log_in);
        txtpassword=(EditText)findViewById((R.id.Password));
        //yourTextView.setTransformationMethod(new PasswordTransformationMethod());
        String username=txtusername.getText().toString();
        String password=txtpassword.getText().toString();
        Cursor c=myDb.validateUser(username);
        if(!(c.moveToFirst())){
            Toast.makeText(loginpage.this,"No account associated with this username.", Toast.LENGTH_LONG).show();
        }
        if(c.moveToFirst()){
            if(password.equals(c.getString(c.getColumnIndex("PW")))){
                myDb.setUser(username);
                Intent startWCIntent = new Intent(getApplicationContext(), wcpage.class);
                startActivity(startWCIntent);
            }
            else{
                Toast.makeText(loginpage.this,"Invalid password.", Toast.LENGTH_LONG).show();
            }
        }
        c.close();//comment

    }


}