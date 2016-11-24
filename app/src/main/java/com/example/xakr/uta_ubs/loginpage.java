package com.example.xakr.uta_ubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import static android.R.attr.onClick;
import static com.example.xakr.uta_ubs.R.id.textView;

public class loginpage extends AppCompatActivity {
    DBHelper myDb;
    TextView textview;
    //dbManager myDb=new dbManager(this,null,null,1);
   /* private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempt_counter=5;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        //login();
        textview = (TextView) findViewById(R.id.textView5);
        myDb = new DBHelper (this);

        //////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////wcpage stuff




       Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String user = "user";
                String pass = "pass";
                logIn(v, user, pass);
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
        Intent startWCIntent = new Intent(getApplicationContext(), wcpage.class);
        startActivity(startWCIntent);
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



