package com.ak.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    LinearLayout linearLayout;
    ViewPager pager;
    int currentPage = 0;
    Timer timer;
    final  long DELAY_MS = 500;
    final  long PERIOD_MS = 3000;
    LinearLayout llpp1,llpp2,llpp3,llpp4,llpp5,llpp6;
    ImageButton ppHeart1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        linearLayout = (LinearLayout) view.findViewById(R.id.home);
        llpp1 = (LinearLayout) view.findViewById(R.id.pp1);
        llpp2 = (LinearLayout) view.findViewById(R.id.pp2);
        llpp3 = (LinearLayout) view.findViewById(R.id.pp3);
        llpp4 = (LinearLayout) view.findViewById(R.id.pp4);
        llpp5 = (LinearLayout) view.findViewById(R.id.pp5);
        llpp6 = (LinearLayout) view.findViewById(R.id.pp6);
        ppHeart1 = (ImageButton) view.findViewById(R.id.ppHeart1);
        llpp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PopularProduct1.class);
                startActivity(intent);
            }
        });
        ppHeart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ppHeart1.setImageResource(R.drawable.ic_favorite_clicked_24dp);
            }
        });
        llpp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PopularProduct2.class);
                startActivity(intent);
            }
        });
        llpp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PopularProduct3.class);
                startActivity(intent);
            }
        });
        llpp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PopularProduct4.class);
                startActivity(intent);
            }
        });
        llpp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PopularProduct5.class);
                startActivity(intent);
            }
        });
        llpp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PopularProduct6.class);
                startActivity(intent);
            }
        });
        pager = (ViewPager) view.findViewById(R.id.vpSlider);
        pager.setAdapter(new ImageAdapter(getActivity()));

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if(currentPage == 6-1){
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        },DELAY_MS,PERIOD_MS);
        return view;


    }
}
