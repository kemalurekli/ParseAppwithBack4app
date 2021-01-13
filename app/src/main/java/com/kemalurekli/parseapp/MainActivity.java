package com.kemalurekli.parseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {
    private Button signUpButton, logInButton;
    private EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameText = findViewById(R.id.email_address_text);
        passwordText = findViewById(R.id.password_text);
        signUpButton = findViewById(R.id.sign_up_button);
        passwordText = findViewById(R.id.password_text);
        ParseUser parseUser = ParseUser.getCurrentUser();
        if (parseUser!=null){
            Toast.makeText(getApplicationContext(),"Welcome again " + ParseUser.getCurrentUser().getUsername(),Toast.LENGTH_LONG).show();
            //Intent
            Intent intent = new Intent(getApplicationContext(),AfterLoginActivity.class);
            startActivity(intent);
        }


    }
    public void signUp (View view){
        ParseUser user = new ParseUser();
        user.setUsername(usernameText.getText().toString());
        user.setPassword(passwordText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e!=null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"User Created",Toast.LENGTH_LONG).show();
                    //intent
                    Intent intent = new Intent(getApplicationContext(),AfterLoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    public void logIn (View view){
        ParseUser.logInInBackground(usernameText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!=null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Welcome " + user.getUsername(),Toast.LENGTH_LONG).show();
                    //Intent
                    Intent intent = new Intent(getApplicationContext(),AfterLoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}