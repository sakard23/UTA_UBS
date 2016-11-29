package com.example.xakr.uta_ubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.view.View;
import android.widget.TextView;


public class searchpage extends AppCompatActivity {

    DBHelper myDb;
    TextView textView;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchpage);
        String s=getIntent().getStringExtra("KEY");
        myDb = DBHelper.getInstance(this.getApplicationContext());
        textView=(TextView)findViewById(R.id.txtview);

        c=myDb.getMemberAllData();
        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext()){
            if((c.getString(1)).equalsIgnoreCase(s)|| (c.getString(2)).equalsIgnoreCase(s) ||
                    (c.getString(3)).equalsIgnoreCase(s) || (c.getString(4).equals(s))){
                buffer.append("Name: "+c.getString(1)+" "+c.getString(2)+"\n");
                buffer.append("Email: "+c.getString(3)+"\n");
                buffer.append("Contact no: "+c.getString(4)+"\n\n");
            }
        }
        c.close();
        textView.setText(buffer);
    }



}
