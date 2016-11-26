package com.example.xakr.uta_ubs;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sellpage extends AppCompatActivity {

    DBHelper myDb;//xakr added
    EditText editItid,editItname,editPrice,editPhoto, editPhnum, editEid, editInfo;//xakr added
    Button btnAddData;//xakr added
    Button btnviewAll;
    Button btnDelete;

    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellpage);

        //myDb=new DBHelper(this); //xakr added
        myDb = DBHelper.getInstance(this.getApplicationContext());

        editItname=(EditText)findViewById(R.id.editText);//xakr added
        editPrice=(EditText)findViewById(R.id.editText3);//xakr added
        editInfo=(EditText)findViewById(R.id.editText4);//xakr added
        editEid=(EditText)findViewById(R.id.editText5);//xakr added
        editPhnum=(EditText)findViewById(R.id.editText2);//xakr added
        editPhoto=(EditText)findViewById(R.id.editText6);//xakr added

        //editDetails=(EditText)findViewById(R.id.editText4);

        btnAddData = (Button)findViewById(R.id.button2);
        btnviewAll = (Button)findViewById(R.id.button18);
        btnviewUpdate= (Button)findViewById(R.id.button20);
        btnDelete= (Button)findViewById(R.id.button19);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    //xakr added function adddata()
    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertTradeData(editItname.getText().toString(),
                                editPrice.getText().toString(), editInfo.getText().toString(),
                                editEid.getText().toString(),
                                editPhnum.getText().toString(), editPhoto.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(sellpage.this, "Item posted into Tradeboard List", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(sellpage.this, "Conflict on Saving Data into System", Toast.LENGTH_LONG).show();

                    }
                });
    }


    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getTradeAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Item Id :"+ res.getString(0)+"\n");
                            buffer.append("Item Name :"+ res.getString(1)+"\n");
                            buffer.append("Price :"+ res.getString(2)+"\n");
                            buffer.append("Details :"+ res.getString(2)+"\n");
                            buffer.append("Email ID :"+ res.getString(2)+"\n");
                            buffer.append("Phone Number) :"+ res.getString(3)+"\n");
                            buffer.append("Photo :"+ res.getString(2)+"\n");
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
                        boolean isUpdate = myDb.updateTradeData(editItid.getText().toString(),editItname.getText().toString(),
                                editPrice.getText().toString(), editInfo.getText().toString(),
                                editEid.getText().toString(),
                                editPhnum.getText().toString(), editPhoto.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(sellpage.this,"Item Details Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(sellpage.this,"Error occured. Couldn't Update",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteTradeData(editItid.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(sellpage.this,"Trade Item Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(sellpage.this,"Please Enter Valid Trade Item ID",Toast.LENGTH_LONG).show();
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