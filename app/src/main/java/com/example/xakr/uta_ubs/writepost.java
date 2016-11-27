package com.example.xakr.uta_ubs;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class writepost extends AppCompatActivity {


    DBHelper myDb;
    EditText editWname,editSub ,editPid;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    //boolean check = checkDataBase();
    Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writepost);

        //create new database connection
        myDb = DBHelper.getInstance(this.getApplicationContext());
        //myDb.onCreate();

        editWname = (EditText)findViewById(R.id.wname);
        editSub = (EditText)findViewById(R.id.sub);
        editPid = (EditText)findViewById(R.id.id);
        btnAddData = (Button)findViewById(R.id.post01);
        btnviewAll = (Button)findViewById(R.id.show);
        btnviewUpdate= (Button)findViewById(R.id.update);
        btnDelete= (Button)findViewById(R.id.delete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

   public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertPostData(editWname.getText().toString(),editSub.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(writepost.this,"Your Message is Posted on a Public Tradeboard",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(writepost.this,"Error while posting. Try again.",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getPostAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Pid :"+ res.getString(0)+"\n");
                            //buffer.append("Writer Name :"+ res.getString(1)+"\n");
                            buffer.append("Message :"+ res.getString(2)+"\n\n");

                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updatePostData(editPid.getText().toString(),editWname.getText().toString(),
                                editSub.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(writepost.this,"Message Updated",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(writepost.this,"Error while updating message",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deletePostData(editPid.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(writepost.this,"Post Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(writepost.this,"Please Enter Valid Post ID",Toast.LENGTH_LONG).show();
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
