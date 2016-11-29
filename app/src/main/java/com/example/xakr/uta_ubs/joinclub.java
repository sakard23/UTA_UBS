package com.example.xakr.uta_ubs;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class joinclub extends AppCompatActivity {
    ListView listView;
    clubAdapter adapter;
    DBHelper myDb;



    //DBHelper myDb;
    EditText editMsid,editMscname,editMsnetid;
    Button btnAddData;
    Button btnviewAll;
    //Button btnDelete;
    //boolean check = checkDataBase();
    //Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joinclub);
        //setContentView(R.layout.jpt);//theres layout for this

        //create new database connection
        myDb = DBHelper.getInstance(this.getApplicationContext());
        //myDb.onCreate();

        editMscname = (EditText)findViewById(R.id.select);
        editMsnetid = (EditText)findViewById(R.id.admin);

        editMsid = (EditText)findViewById(R.id.id);
        btnAddData = (Button)findViewById(R.id.send10);
        btnviewAll = (Button)findViewById(R.id.send111);
        //btnviewUpdate= (Button)findViewById(R.id.send001);
        //btnDelete= (Button)findViewById(R.id.send002);
        AddData();
        viewAll();
       // UpdateData();
        //DeleteData();

        listView=(ListView) findViewById(R.id.listView);
        myDb = DBHelper.getInstance(this.getApplicationContext());
        adapter=new clubAdapter(joinclub.this,myDb.returnClub());
        listView.setAdapter(adapter);
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertMsData(editMscname.getText().toString(),
                                editMsid.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(joinclub.this,"Membership Formed",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(joinclub.this,"Club Not Formed",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getClubAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Ms Name :"+ res.getString(1)+"\n");
                            //buffer.append("ADMIN :"+ res.getString(2)+"\n");
                            buffer.append("NIET ID :"+ res.getString(2)+"\n\n");
                        }

                        // Show all data
                        showMessage("Club List",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
