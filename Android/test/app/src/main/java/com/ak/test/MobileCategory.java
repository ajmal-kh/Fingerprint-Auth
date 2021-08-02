package com.ak.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MobileCategory extends AppCompatActivity {
    private LinearLayout mobile1, mobile2, mobile3, mobile4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_category);
        mobile1 = (LinearLayout) findViewById(R.id.mobile1);
        mobile2 = (LinearLayout) findViewById(R.id.mobile2);
        mobile3 = (LinearLayout) findViewById(R.id.mobile3);
        mobile4 = (LinearLayout) findViewById(R.id.mobile4);

        mobile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobileCategory.this, Cmobile1.class);
                startActivity(intent);
            }
        });
        mobile2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobileCategory.this, Cmobile2.class);
                startActivity(intent);
            }
        });
        mobile3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobileCategory.this, Cmobile3.class);
                startActivity(intent);
            }
        });
        mobile4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MobileCategory.this, Cmobile4.class);
                startActivity(intent);
            }
        });
    }
}
