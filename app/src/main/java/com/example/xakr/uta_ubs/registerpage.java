package com.example.xakr.uta_ubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class registerpage extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText dob;
    EditText email;
    EditText phone;
    EditText userName;
    EditText password;
    EditText netId;
    dbManager myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        firstName=(EditText) findViewById(R.id.firstName);
        lastName=(EditText)findViewById(R.id.lastName);
        dob=(EditText)findViewById(R.id.dob);
        email=(EditText)findViewById(R.id.email);
        netId=(EditText)findViewById(R.id.netId);
        phone=(EditText)findViewById(R.id.phone);
        userName=(EditText)findViewById(R.id.userName);
        password=(EditText)findViewById(R.id.password);


        myDb=(dbManager) getIntent().getSerializableExtra("myDb");
    }

    public void createAccount(){
        User user=new User();
        user.set_fisrtName(firstName.getText().toString());
        user.set_lastName(lastName.getText().toString());
        user.set_dob(dob.getText().toString());
        user.set_email(email.getText().toString());
        user.set_phone(phone.getText().toString());
        user.set_userName(userName.getText().toString());
        user.set_password(password.getText().toString());
        user.set_netId(netId.getText().toString());
        myDb.addUser(user);
    }


}
