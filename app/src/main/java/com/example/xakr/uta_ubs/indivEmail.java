package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.xakr.uta_ubs.R.id.listView;

/**
 * Created by Sushil on 11/28/2016.
 */

public class indivEmail extends AppCompatActivity {
    ListView listView;
    DBHelper myDb;
    indivEmailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indivlistview);

        listView = (ListView) findViewById(R.id.indivListView);
        myDb = DBHelper.getInstance(this.getApplicationContext());
        adapter = new indivEmailAdapter(indivEmail.this, myDb.returnUser());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SendEmail();
            }
        });
    }

    public void SendEmail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"sushil.bista009@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT, "body of email");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(indivEmail.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
