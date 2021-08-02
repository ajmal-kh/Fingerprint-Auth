package com.ak.test;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Parcelable;
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

import org.w3c.dom.Text;

public class PopularProduct1 extends AppCompatActivity {
    private Button bvBuyNow, bvA2Cart;
    TextView tvFeature, tvWarranty;
    //slider dots
    LinearLayout slideDots;
    private int dotscount;
    private ImageView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_product1);

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
        TextView pp2_pn =(TextView) findViewById(R.id.pp2_pn);
        Intent intent = new Intent(this, OrderSuccessfull1.class);
        intent.putExtra("pp", (Parcelable) pp2_pn);
        startActivity(intent);

        bvBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopularProduct1.this,PlaceOrder1.class);
                startActivity(intent);
            }
        });
        bvA2Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopularProduct1.this,"Item Added To Cart",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
