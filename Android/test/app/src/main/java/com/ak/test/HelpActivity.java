package com.ak.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelpActivity extends AppCompatActivity {
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getSupportActionBar().setTitle("Help");

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText subject = (EditText) findViewById(R.id.subject);
        final EditText message = (EditText) findViewById(R.id.message);
        final Button sendMessage = (Button) findViewById(R.id.sendMessage);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Subject = subject.getText().toString();
                String Message = message.getText().toString();
                if (TextUtils.isEmpty(Name)){
                    name.setError("Enter Your Name");
                    name.requestFocus();
                    return;
                }

                Boolean onError = false;
                if (!isValidEmail(Email)) {
                    onError = true;
                    email.setError("Invalid Email");
                    return;
                }

                if (TextUtils.isEmpty(Subject)){
                    subject.setError("Enter Your Subject");
                    subject.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(Message)){
                    message.setError("Enter Your Message");
                    message.requestFocus();
                    return;
                }
                Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);

                /* Fill it with Data */
                sendEmail.setType("plain/text");
                sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"khanajmal7861@gmail.com"});
                sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, Subject);
                sendEmail.putExtra(android.content.Intent.EXTRA_TEXT,
                        "name:"+Name+'\n'+"Email ID:"+Email+'\n'+"Message:"+'\n'+Message);

                /* Send it off to the Activity-Chooser */
                startActivity(Intent.createChooser(sendEmail, "Send mail..."));

            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        //Get a Tracker (should auto-report)


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
