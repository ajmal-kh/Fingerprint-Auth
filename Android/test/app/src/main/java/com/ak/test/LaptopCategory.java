package com.ak.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class LaptopCategory extends AppCompatActivity {
    private LinearLayout laptop1, laptop2, laptop3, laptop4, laptop5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laptop_category);
        laptop1 = (LinearLayout) findViewById(R.id.laptop1);
        laptop2 = (LinearLayout) findViewById(R.id.laptop2);
        laptop3 = (LinearLayout) findViewById(R.id.laptop3);
        laptop4 = (LinearLayout) findViewById(R.id.laptop4);
        laptop5 = (LinearLayout) findViewById(R.id.laptop5);

        laptop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaptopCategory.this,Claptop1.class);
                startActivity(intent);
            }
        });
        laptop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaptopCategory.this,Claptop2.class);
                startActivity(intent);
            }
        });
        laptop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaptopCategory.this,Claptop3.class);
                startActivity(intent);
            }
        });
        laptop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaptopCategory.this,Claptop4.class);
                startActivity(intent);
            }
        });
        laptop5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaptopCategory.this,Claptop5.class);
                startActivity(intent);
            }
        });

    }
}
