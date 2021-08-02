package com.ak.test;

import android.Manifest;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ak.test.FingerprintHandler;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class FingerprintLogin extends AppCompatActivity {

    private TextView mHeadingPanel;
    private ImageView mFingerprintImage;
    private TextView mParaPanel;
    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint_login);

        mHeadingPanel = (TextView) findViewById(R.id.headingPanel);
        mFingerprintImage = (ImageView) findViewById(R.id.fingerprintImage);
        mParaPanel = (TextView) findViewById(R.id.paraPanel);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
            keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

            if(!fingerprintManager.isHardwareDetected()){
                mParaPanel.setText("Fingerprint Scanner not detected in device");
            }else if(ContextCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED){
                mParaPanel.setText("Permission not granted to use Fingerprint Scanner");
            }else if(!keyguardManager.isKeyguardSecure()){
                mParaPanel.setText("Add Lock to your Phone in settings");
            }else if(!fingerprintManager.hasEnrolledFingerprints()){
                mParaPanel.setText("Your should add atleast 1 Fingerprint to use this Feature");
            }else {
                mParaPanel.setText("Place your Finger on scanner to Login");
                FingerprintHandler fingerprintHandler = new FingerprintHandler(this);
                fingerprintHandler.startAuth(fingerprintManager, null);
            }
        }
    }
}

