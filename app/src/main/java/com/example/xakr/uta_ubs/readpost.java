package com.example.xakr.uta_ubs;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class readpost extends AppCompatActivity {
    DBHelper myDb;
    TextView txtview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postpage);
        myDb = DBHelper.getInstance(this.getApplicationContext());

        StringBuffer buffer=new StringBuffer();
        Cursor res=myDb.getPostAllData();
        while(res.moveToNext()){
            buffer.append("Writer Name :"+ res.getString(1)+"\n");
            buffer.append("Status :"+ res.getString(2)+"\n\n\n");
        }
        txtview=(TextView)findViewById(R.id.viewPost);
        txtview.setText(buffer);
    }

}
