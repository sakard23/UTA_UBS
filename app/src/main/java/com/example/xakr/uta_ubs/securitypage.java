package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class securitypage extends AppCompatActivity {
    DBHelper myDb;
    EditText sec_ques, sq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_securitypage);
        myDb = DBHelper.getInstance(this.getApplicationContext());
    }

    public void security(View view) {
        sec_ques = (EditText) findViewById(R.id.sec_ques);
        sq=(EditText)findViewById(R.id.sq);
        String netId = sec_ques.getText().toString();
        String sqAns=sq.getText().toString();
        Cursor c = myDb.getEmail(netId);
        /*if (c.moveToFirst()) {
            String email = c.getString(c.getColumnIndex("EMAILID"));
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            i.putExtra(Intent.EXTRA_SUBJECT, "Your password");
            i.putExtra(Intent.EXTRA_TEXT, "Your password is " + (c.getString(c.getColumnIndex("PW"))));
            try {
                startActivity(Intent.createChooser(i, ""));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(securitypage.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }
        }*/
        String ans1,ans2;
        if (c.moveToFirst()) {
             ans1= c.getString(c.getColumnIndex("NETID"));
             ans2= c.getString(c.getColumnIndex("SQ"));
             if((ans1.equals(netId)) && (ans2.equals(sqAns))) {
                 AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                 AlertDialog dialog = alertDialogBuilder.create();
                 dialog.setMessage("Your Username: " + c.getString(c.getColumnIndex("UNAME")) + "\nPassword: " + c.getString(c.getColumnIndex("PW")));
                 dialog.show();
             }
             else{
                 Toast.makeText(securitypage.this, "Invalid Input", Toast.LENGTH_SHORT).show();
             }

        }
        if(!(c.moveToFirst())){
            Toast.makeText(securitypage.this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
    }
}


