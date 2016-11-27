package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class postpage extends AppCompatActivity {
    TextView viewPost;
    DBHelper myDb;
    EditText post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postpage);
        myDb = DBHelper.getInstance(this.getApplicationContext());
        readPost();
        /*Button write = (Button) findViewById(R.id.button10);
        write.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), writepost.class);
                startActivity(i);
            }


        });

        Button read = (Button) findViewById(R.id.button11);
        read.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), readpost.class);
                startActivity(i);
            }


        });*/


    }

    /*public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }*/

    public void createPost(View view){
        post=(EditText) findViewById(R.id.create);
        String message=post.getText().toString();
        Cursor c=myDb.getUser();
        myDb.insertPostData(c.getString(c.getColumnIndex("FNAME")),c.getString(c.getColumnIndex("LNAME")),message);
        readPost();
    }

    public void readPost(){
        String message="";
        viewPost=(TextView)findViewById(R.id.viewPost);
        Cursor c=myDb.getPostAllData();
        c.moveToFirst();
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("COL_SUB"))!=null){
                message=message+c.getString(c.getColumnIndex("FNAME"))+" "+c.getString(c.getColumnIndex("LNAME"))+"\n"+c.getString(c.getColumnIndex("COL_SUB"))+"\n";
            }
            c.moveToNext();
        }
        viewPost.setText(message);
    }
}
