package com.ak.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class TelevisionCategory extends AppCompatActivity {

    private LinearLayout tv1, tv2, tv3, tv4, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.television_category);
        tv1 = (LinearLayout) findViewById(R.id.tv1);
        tv2 = (LinearLayout) findViewById(R.id.tv2);
        tv3 = (LinearLayout) findViewById(R.id.tv3);
        tv4 = (LinearLayout) findViewById(R.id.tv4);
        tv5 = (LinearLayout) findViewById(R.id.tv5);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelevisionCategory.this,Ctv1.class);
                startActivity(intent);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelevisionCategory.this,Ctv2.class);
                startActivity(intent);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelevisionCategory.this,Ctv3.class);
                startActivity(intent);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelevisionCategory.this,Ctv4.class);
                startActivity(intent);
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelevisionCategory.this,Ctv5.class);
                startActivity(intent);
            }
        });

    }
}
