package com.example.xakr.uta_ubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class writepost extends AppCompatActivity {
    
    ArrayList<String> selection= new ArrayList<String>(); //select item will be recorded into array list
    TextView final_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writepost);

        final_text=(TextView)findViewById(R.id.activity_sendmsg);
    }
    public void selectClub(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.chessclub:
                if (checked) {
                    selection.add("Chess club");
                } else {
                    selection.remove("Chess club");
                }
                break;
            case R.id.scienceclub:
                if (checked) {
                    selection.add("Science club");
                } else {
                    selection.remove("Science club");
                }
                break;
            case R.id.c4p:
                if (checked)
                {
                    selection.add("Code for Peace");
                }
                else{
                    selection.remove("Code for Peace");
                }
                break;
        }
    }
    
    public void finalSelection (View view)
    {
        String final_club_selection=" ";
        for (String x: selection)
        {
            final_club_selection=final_club_selection+x+"\n";
        }
    }
}
