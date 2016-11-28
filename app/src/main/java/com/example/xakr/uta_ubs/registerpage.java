package com.example.xakr.uta_ubs;

import android.content.Intent;
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
    EditText editFname,editLname,editEid,editPhnum, editNid, editUname,editPw,editSq;//xakr added
    Button btnAddData;//xakr added

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);

        //myDb=new DBHelper(this); //xakr added
        myDb = DBHelper.getInstance(this.getApplicationContext());

        editFname=(EditText)findViewById(R.id.firstName);//xakr added
        editLname=(EditText)findViewById(R.id.lastName);//xakr added
        editEid=(EditText)findViewById(R.id.email);//xakr added
        editPhnum=(EditText)findViewById(R.id.phone);//xakr added
        editNid=(EditText)findViewById(R.id.netId);//xakr added
        editUname=(EditText)findViewById(R.id.userName);//xakr added
        editPw=(EditText)findViewById(R.id.password);//xakr added
        editSq=(EditText)findViewById(R.id.sq);
        btnAddData=(Button)findViewById(R.id.button10);//xakr added
        AddData(); //xakr added
    }


    //xakr added function adddata()
    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        boolean isInserted=myDb.insertMemberData(editFname.getText().toString(),
                                editLname.getText().toString(),editEid.getText().toString(),
                                editPhnum.getText().toString(),editNid.getText().toString(),
                                editUname.getText().toString(),editPw.getText().toString(),
                                editSq.getText().toString());
                        if (isInserted==true)
                            Toast.makeText(registerpage.this,"Registration Successful", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(registerpage.this,"Error occured while Registration. Please Try Again", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),loginpage.class);
                        startActivity(intent);
                    }
                }
        );
    }

}
