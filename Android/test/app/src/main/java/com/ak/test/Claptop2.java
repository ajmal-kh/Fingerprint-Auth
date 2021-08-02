package com.ak.test;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Claptop2 extends AppCompatActivity {
    private Button bvBuyNow, bvA2Cart;
    ViewPager pager;
    TextView tvFeature, tvWarranty;
    //slider dots
    LinearLayout slideDots;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.claptop2);

        bvBuyNow = (Button) findViewById(R.id.bvBuyNow);
        bvA2Cart = (Button) findViewById(R.id.bvA2Cart);
        tvFeature = (TextView) findViewById(R.id.tvFeature);
        String text = "Features And Details";
        SpannableString ss = new SpannableString(text);
        StyleSpan bold = new StyleSpan(Typeface.BOLD);
        ss.setSpan(bold,0,20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvFeature.setText(ss);
        tvWarranty = (TextView) findViewById(R.id.tvWarranty);
        String text1 = "Warranty Information";
        SpannableString ss1= new SpannableString(text1);
        StyleSpan bold1 = new StyleSpan(Typeface.BOLD);
        ss1.setSpan(bold1,0,20,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvWarranty.setText(ss1);

        pager = (ViewPager) findViewById(R.id.vpSlider);

        bvBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Claptop2.this,Claptop2Order.class);
                startActivity(intent);
            }
        });
        bvA2Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Claptop2.this,"Item Added To Cart",Toast.LENGTH_SHORT).show();
            }
        });

        LaptopAdapter2 laptopAdapter2 = new LaptopAdapter2(this);
        pager.setAdapter(laptopAdapter2);

        //slider dots
        slideDots = (LinearLayout) findViewById(R.id.slideDots);
        dotscount = laptopAdapter2.getCount();
        dots = new ImageView[dotscount];
        for (int i = 0; i<dotscount; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            slideDots.addView(dots[i],params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //slider dots
    }
}
