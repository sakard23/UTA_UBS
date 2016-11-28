package com.example.xakr.uta_ubs;


import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createclub extends AppCompatActivity {

    DBHelper myDb;
    EditText editCname,editAdmin,editNetid,editFunc,editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    //boolean check = checkDataBase();
    Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createclub);

        //create new database connection
        myDb = DBHelper.getInstance(this.getApplicationContext());
        //myDb.onCreate();

        editCname = (EditText)findViewById(R.id.select);
        editAdmin = (EditText)findViewById(R.id.admin);
        editNetid = (EditText)findViewById(R.id.net_id);
        editFunc = (EditText)findViewById(R.id.func);
        editTextId = (EditText)findViewById(R.id.id);
        btnAddData = (Button)findViewById(R.id.send10);
        btnviewAll = (Button)findViewById(R.id.send111);
        btnviewUpdate= (Button)findViewById(R.id.send001);
        btnDelete= (Button)findViewById(R.id.send002);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertClubData(editCname.getText().toString(),
                                editAdmin.getText().toString(),
                                editFunc.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(createclub.this,"Club Formed",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(createclub.this,"Club Not Formed",Toast.LENGTH_LONG).show();
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
                            buffer.append("CLUB Name :"+ res.getString(1)+"\n");
                            //buffer.append("ADMIN :"+ res.getString(2)+"\n");
                            buffer.append("CLUB FUNCTION(S) :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Club List",buffer.toString());
                    }
                }
        );
    }

    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateClubData(editTextId.getText().toString(),
                                editCname.getText().toString(),
                                editAdmin.getText().toString(),editFunc.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(createclub.this,"Club Details Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(createclub.this,"Club Details not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteClubData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(createclub.this,"Club Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(createclub.this,"Please Enter Valid Club ID",Toast.LENGTH_LONG).show();
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
