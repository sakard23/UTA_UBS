package com.example.xakr.uta_ubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.view.View;


public class searchpage extends AppCompatActivity {

    //DatabaseEvent db;
    DBHelper db;
    //EditText searchEntry;
    EditText search;
//    Button btnSearch;
    //EditText dateEntry;

    Button button;
    //EditText dateEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wcpage);
        db = new DBHelper(this);
        EditText search = (EditText) findViewById(R.id.search);
        button = (Button) findViewById(R.id.button007);
        //dateEntry = (EditText)findViewById(R.id.editText_dateSearch);

        //EditText txtDate=(EditText)findViewById(R.id.editText_dateSearch);
        //txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener(){



   // Search();

}
/*
    public void Search(){
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = searchEntry.getText().toString();

                    Cursor results = db.getInfo(query);
                    if (results != null && results.getCount() != 0) {
                        buildBufferEvent(results);
                        return;
                    } else {
                        showMessage("Search Results", "Your Search ' " + searchEntry.getText().toString() + " ' did not match any information.");
                        return;
                    }

            }
        });
    }*/

    public void buildBufferEvent(Cursor results)
    {
        StringBuffer buffer = new StringBuffer();
        while(results.moveToNext()) {
            buffer.append("Name: " + results.getString(1) + results.getString(2)+"\n");
            buffer.append("Email ID : " + results.getString(3) + "\n");
            buffer.append("Phone Number : " + results.getString(4) + "\n");

        }

        showMessage("Search Results ", buffer.toString());

    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
