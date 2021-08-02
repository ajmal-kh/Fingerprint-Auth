package com.ak.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SpeakerCategory extends AppCompatActivity {

    private LinearLayout speaker1, speaker2, speaker3, speaker4, speaker5, speaker6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speaker_category);
        speaker1 = (LinearLayout) findViewById(R.id.speaker1);
        speaker2 = (LinearLayout) findViewById(R.id.speaker2);
        speaker3 = (LinearLayout) findViewById(R.id.speaker3);
        speaker4 = (LinearLayout) findViewById(R.id.speaker4);
        speaker5 = (LinearLayout) findViewById(R.id.speaker5);
        speaker6 = (LinearLayout) findViewById(R.id.speaker6);

        speaker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpeakerCategory.this,Cspeaker1.class);
                startActivity(intent);
            }
        });
        speaker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpeakerCategory.this,Cspeaker2.class);
                startActivity(intent);
            }
        });
        speaker3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpeakerCategory.this,Cspeaker3.class);
                startActivity(intent);
            }
        });
        speaker4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpeakerCategory.this,Cspeaker4.class);
                startActivity(intent);
            }
        });
        speaker5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpeakerCategory.this,Cspeaker5.class);
                startActivity(intent);
            }
        });
        speaker6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpeakerCategory.this,Cspeaker6.class);
                startActivity(intent);
            }
        });

    }
}
