package com.ak.test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ak.test.R;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    Boolean isValidationSuccessFull = true;
    private EditText etAge;
    private EditText etName;
    private EditText etUsername;
    private EditText etPassword;
    private Button bRegister;
    private TextView tvAlreadySignIn;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //final EditText etAge=(EditText) findViewById(R.id.etAge);
        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        //final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bRegister = (Button) findViewById(R.id.bRegister);
        final TextView tvAlreadySignIn = (TextView) findViewById(R.id.tvAlreadySignIn);
        progressDialog = new ProgressDialog(RegisterActivity.this);
        tvAlreadySignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(intent);
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getText().toString();
                if(name.isEmpty()){
                    etName.setError("enter name");
                    isValidationSuccessFull = false;
                } else {
                    isValidationSuccessFull = true;
                }
                final String username = etUsername.getText().toString();
                if(username.isEmpty()){
                    etUsername.setError("enter username");
                    isValidationSuccessFull = false;

                }else {
                    isValidationSuccessFull = true;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse= new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                                Toast.makeText(RegisterActivity.this, "Registration successfull", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                if(isValidationSuccessFull) {
                    RegisterRequest registerRequest = new RegisterRequest(name, username, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(registerRequest);
                    progressDialog.setMessage("Registering User...");
                    progressDialog.show();
                } else {
                    Toast.makeText(RegisterActivity.this, "enter valid details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
