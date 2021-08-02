package com.ak.test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private  Button bLogin;
    private TextView registerLink;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SessionManager sessionManager; // new

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(LoginActivity.this);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        //final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView  registerLink = (TextView) findViewById(R.id.tvRegisterHere);
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        sessionManager = new SessionManager(this); // new
        editor = sharedPreferences.edit();

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername.getText().toString();
                //final String password = etPassword.getText().toString();
                progressDialog.setMessage("Founding Match...");
                progressDialog.show();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                String name = jsonResponse.getString("name");
                                progressDialog.dismiss();

                                sessionManager.createSession(name,username);
                                Intent intent = new Intent(LoginActivity.this, FingerprintLogin.class);
                                intent.putExtra("name",name);
                                intent.putExtra("username",username);

                                LoginActivity.this.startActivity(intent);
                                Toast.makeText(LoginActivity.this, "Match Found", Toast.LENGTH_SHORT).show();

                            }else {
                                AlertDialog.Builder builder= new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("login failed")
                                        .setNegativeButton("retry",null)
                                        .create()
                                        .show();
                                progressDialog.dismiss();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}