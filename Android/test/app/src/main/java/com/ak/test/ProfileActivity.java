package com.ak.test;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {
    private EditText etUsername;
    private TextView welcomeMsg;
    SessionManager sessionManager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();
        etUsername = (EditText) findViewById(R.id.etUsername);
        welcomeMsg = (TextView) findViewById(R.id.tvWelcomeMsg);
        getSupportActionBar().setTitle("Profile");

        //sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        HashMap<String, String> user = sessionManager.getUserDetail();
        String mName = user.get(sessionManager.NAME);
        String mUsername = user.get(sessionManager.USERNAME);
        etUsername.setText(mUsername);
        String message = mName + "\twelcome to your user area";
        welcomeMsg.setText(message);
        //etUsername.setText(sharedPreferences.getString("username",null));
        //etAge.setText(sharedPreferences.getString("age", String.valueOf(-1)));
    }
}

