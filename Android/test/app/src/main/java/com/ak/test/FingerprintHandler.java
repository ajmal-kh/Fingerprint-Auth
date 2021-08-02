package com.ak.test;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.M)
public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {
    private Context context;
    private Activity ctx;

    public FingerprintHandler(Context context){
        this.context = context;
    }
    public void startAuth(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject) {
        CancellationSignal cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        this.update("There was an Auth Error. " + errString,  false);
    }

    @Override
    public void onAuthenticationFailed() {
        this.update("Couldn't verify fingerprint try again. ", false);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        this.update("Error: " + helpString, false);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        Toast toast;
        toast = Toast.makeText(context, "Login Successfull", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this.context, MainActivity.class);
        this.context.startActivity(intent);
    }


    private void update(String s, boolean b) {
        TextView paraPanel = (TextView) ((Activity) context).findViewById(R.id.paraPanel);
        ImageView imageView = (ImageView) ((Activity) context).findViewById(R.id.fingerprintImage);
        paraPanel.setText(s);
        if(b==false){
            paraPanel.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        }else{
            paraPanel.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
        }
    }
}
