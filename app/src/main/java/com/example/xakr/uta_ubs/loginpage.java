package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.onClick;
import static com.example.xakr.uta_ubs.R.id.textView;

public class loginpage extends AppCompatActivity {

    TextView textview;
   /* private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempt_counter=5;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wcpage);
        //login();
        textview = (TextView) findViewById(R.id.textView5);

        //////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////wcpage stuff




        Button T = (Button) findViewById(R.id.button4);
        T.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), clubpage.class);
                startActivity(i);
            }
        });
        Button U = (Button) findViewById(R.id.button7);
        T.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), tradepage.class);
                startActivity(i);
            }
        });
        Button V = (Button) findViewById(R.id.button8);
        T.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), postpage.class);
                startActivity(i);
            }
        });
        Button W = (Button) findViewById(R.id.button9);
        T.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), emailpage.class);
                startActivity(i);
            }
        });


    }

///////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////


    public void registerUser(View view){
        Intent intent=new Intent(this, registerpage.class);
        startActivity(intent);
    }
    public void logIn(View view, String username, String password){

    }

    ////////////////////////////////////////////////////////////////////////////////////
    //////////////////wcpage stuff/////////////////////////////////////////////////////

    /*public void onClick (View view)
    {
    String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("@string/club"))
        {
            Intent intent = new Intent(this, clubpage.class);
            startActivity(intent);
        }
        else if (button_text.equals("@string/trade"))
        {
            Intent intent = new Intent(this, tradepage.class);
            startActivity(intent);
        }
        else if (button_text.equals("@string/post"))
        {
            Intent intent = new Intent(this, postpage.class);
            startActivity(intent);
        }
        else if (button_text.equals("@string/email"))
        {
            Intent intent = new Intent(this, emailpage.class);
            startActivity(intent);
        }

    }*/






    ///////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /*public void login(){
        username=(EditText)findViewById(R.id.log_in);
        password=(EditText)findViewById(R.id.Password);
        attempts=(TextView) findViewById(R.id.editText);
        login_btn= (Button)findViewById(R.id.signup);

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if ((username.getText().toString().equals("user")) &&
                        (password.getText().toString().equals("pass")))
                        {
                         Toast.makeText(loginpage.this, "Welcome to the UTA University Bazaar System",
                                 Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(loginpage.this, "Invalid username or password. Please Try again.",
                                    Toast.LENGTH_SHORT).show();
                            attempt_counter--;
                            if (attempt_counter==0){
                                login_btn.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }*/
}



