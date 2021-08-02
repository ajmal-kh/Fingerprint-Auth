package com.ak.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HeadphoneCategory extends AppCompatActivity {
    private LinearLayout headphone1, headphone2, headphone3, headphone4, headphone5, headphone6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.headphone_category);
        headphone1 = (LinearLayout) findViewById(R.id.headphone1);
        headphone2 = (LinearLayout) findViewById(R.id.headphone2);
        headphone3 = (LinearLayout) findViewById(R.id.headphone3);
        headphone4 = (LinearLayout) findViewById(R.id.headphone4);
        headphone5 = (LinearLayout) findViewById(R.id.headphone5);
        headphone6 = (LinearLayout) findViewById(R.id.headphone6);

        headphone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeadphoneCategory.this,Cheadphone1.class);
                startActivity(intent);
            }
        });
        headphone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeadphoneCategory.this,Cheadphone2.class);
                startActivity(intent);
            }
        });
        headphone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeadphoneCategory.this,Cheadphone3.class);
                startActivity(intent);
            }
        });
        headphone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeadphoneCategory.this,Cheadphone4.class);
                startActivity(intent);
            }
        });
        headphone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeadphoneCategory.this,Cheadphone5.class);
                startActivity(intent);
            }
        });
        headphone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HeadphoneCategory.this,Cheadphone6.class);
                startActivity(intent);
            }
        });

    }
}
