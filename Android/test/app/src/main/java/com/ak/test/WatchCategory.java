package com.ak.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class WatchCategory extends AppCompatActivity {
    LinearLayout watch1, watch2,watch3, watch4, watch5, watch6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_category);
        watch1 = (LinearLayout) findViewById(R.id.watch1);
        watch2 = (LinearLayout) findViewById(R.id.watch2);
        watch3 = (LinearLayout) findViewById(R.id.watch3);
        watch4 = (LinearLayout) findViewById(R.id.watch4);
        watch5 = (LinearLayout) findViewById(R.id.watch5);
        watch6 = (LinearLayout) findViewById(R.id.watch6);

        watch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WatchCategory.this,Cwatch1.class);
                startActivity(intent);
            }
        });
        watch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WatchCategory.this,Cwatch2.class);
                startActivity(intent);
            }
        });
        watch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WatchCategory.this,Cwatch3.class);
                startActivity(intent);
            }
        });
        watch4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WatchCategory.this,Cwatch4.class);
                startActivity(intent);
            }
        });
        watch5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WatchCategory.this,Cwatch5.class);
                startActivity(intent);
            }
        });
        watch6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WatchCategory.this,Cwatch6.class);
                startActivity(intent);
            }
        });

    }
}
