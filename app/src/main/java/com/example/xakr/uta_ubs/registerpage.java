package com.example.xakr.uta_ubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registerpage extends AppCompatActivity {

    DBHelper myDb;//xakr added
    EditText editFname,editLname,editEid,editPhnum, editNid, editUname,editPw;//xakr added
    Button btnAddData;//xakr added

   //susil db code
/*    EditText firstName;
    EditText lastName;
    EditText dob;
    EditText email;
    EditText phone;
    EditText userName;
    EditText password;
    EditText netId;
    //dbManager myDb;//susil
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);

        //susil db code
/*        firstName=(EditText) findViewById(R.id.firstName);
        lastName=(EditText)findViewById(R.id.lastName);
        dob=(EditText)findViewById(R.id.dob);
        email=(EditText)findViewById(R.id.email);
        netId=(EditText)findViewById(R.id.netId);
        phone=(EditText)findViewById(R.id.phone);
        userName=(EditText)findViewById(R.id.userName);
        password=(EditText)findViewById(R.id.password);
*/

        //myDb=(dbManager) getIntent().getSerializableExtra("myDb");//susil

        myDb=new DBHelper(this); //xakr added

        editFname=(EditText)findViewById(R.id.firstName);//xakr added
        editLname=(EditText)findViewById(R.id.lastName);//xakr added
        editEid=(EditText)findViewById(R.id.email);//xakr added
        editPhnum=(EditText)findViewById(R.id.phone);//xakr added
        editNid=(EditText)findViewById(R.id.netId);//xakr added
        editUname=(EditText)findViewById(R.id.userName);//xakr added
        editPw=(EditText)findViewById(R.id.password);//xakr added

        btnAddData=(Button)findViewById(R.id.button10);//xakr added
        AddData(); //xakr added
    }

    //xakr added function adddata()
    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        boolean isInserted=myDb.insertData(editFname.getText().toString(),
                                editLname.getText().toString(),editEid.getText().toString(),
                                editPhnum.getText().toString(),editNid.getText().toString(),
                                editUname.getText().toString(),editPw.getText().toString());
                        if (isInserted==true)
                            Toast.makeText(registerpage.this,"data inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(registerpage.this,"data not inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
/*//susil
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
*/

}
