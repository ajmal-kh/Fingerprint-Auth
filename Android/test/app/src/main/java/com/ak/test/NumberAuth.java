package com.ak.test;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class NumberAuth extends AppCompatActivity {
    private static final String TAG = "PhoneLogin";
    private boolean mVerificationInProgress = false;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private FirebaseAuth firebaseAuth;
    EditText etNumber;
    EditText etVerification;
    Button btnSendOTP;
    Button btnVerifyOTP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_auth);
        firebaseAuth = FirebaseAuth.getInstance();

        etNumber = (EditText) findViewById(R.id.etNumber);
        etVerification = (EditText) findViewById(R.id.etVerification);

        btnSendOTP = (Button) findViewById(R.id.btnSendOTP);
        btnVerifyOTP = (Button) findViewById(R.id.btnVerifyOTP);

        firebaseAuth = FirebaseAuth.getInstance();
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                mVerificationInProgress = false;
                Toast.makeText(NumberAuth.this,"Done",Toast.LENGTH_SHORT).show();
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(NumberAuth.this,"Failed",Toast.LENGTH_SHORT).show();
                if(e instanceof FirebaseAuthInvalidCredentialsException){
                    Toast.makeText(NumberAuth.this,"Invalid Phone Number",Toast.LENGTH_SHORT).show();
                }
                else if (e instanceof FirebaseTooManyRequestsException){

                }

            }
            public void onCodeSent(String verificationId,PhoneAuthProvider.ForceResendingToken token){
                Toast.makeText(NumberAuth.this,"Verification Code has been sent on your number",Toast.LENGTH_SHORT).show();
                mVerificationId = verificationId;
                mResendToken = token;
                etNumber.setVisibility(View.GONE);
                btnSendOTP.setVisibility(View.GONE);
                etVerification.setVisibility(View.VISIBLE);
                btnVerifyOTP.setVisibility(View.VISIBLE);
            }
        };
        btnSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        etNumber.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        NumberAuth.this,
                        mCallbacks);
            }
        });
        btnVerifyOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(mVerificationId, etVerification.getText().toString());
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }
        });
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        firebaseAuth.signInWithCredential(phoneAuthCredential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Order successfull",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(NumberAuth.this,OrderSuccessfull1.class));
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(getApplicationContext(), "Error",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

}
