package com.example.xakr.uta_ubs;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*
public class writeemail extends AppCompatActivity {

    DBHelper myDb;
    EditText editEmid, editFrom,editTo,editTop,editMsg;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    //boolean check = checkDataBase();
    //Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createclub);

        //create new database connection
        myDb = DBHelper.getInstance(this.getApplicationContext());
        //myDb.onCreate();

        editFrom = (EditText)findViewById(R.id.from);
        editTo = (EditText)findViewById(R.id.to);
        editTop = (EditText)findViewById(R.id.top);
        editMsg = (EditText)findViewById(R.id.msg);

        btnAddData = (Button)findViewById(R.id.post01);
        btnviewAll = (Button)findViewById(R.id.show);
        //btnviewUpdate= (Button)findViewById(R.id.send001);
        btnDelete= (Button)findViewById(R.id.delete);
        AddData();
        viewAll();
        //UpdateData();
        DeleteData();
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertEmailData(editFrom.getText().toString(),
                                editTo.getText().toString(),editTop.getText().toString(),
                                editMsg.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(writeemail.this,"Club Formed",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(writeemail.this,"Club Not Formed",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getEmailAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Email ID :"+ res.getString(0)+"\n");
                            //buffer.append("CLUB Name :"+ res.getString(1)+"\n");
                            buffer.append("To :"+ res.getString(2)+"\n");
                            buffer.append("Email :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Email History",buffer.toString());
                    }
                }
        );
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteEmailData(editEmid.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(writeemail.this,"Email Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(writeemail.this,"Please Enter Valid Email ID number",Toast.LENGTH_LONG).show();
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
*/