package com.ak.test;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageAdapter extends PagerAdapter {
    View view;
    Context context;
    ImageAdapter(Context context){
        this.context = context;
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ImageView) object);
    }

    private int[] sliderImageId = new int[]{
            R.drawable.np1, R.drawable.np2, R.drawable.np3, R.drawable.np4, R.drawable.np5
    };

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(sliderImageId[position]);
        ((ViewPager) container).addView(imageView,0);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position == 0){
                    Intent intent = new Intent(v.getContext(),NewProduct1.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 1){
                    Intent intent = new Intent(v.getContext(),NewProduct2.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 2){
                    Intent intent = new Intent(v.getContext(),NewProduct3.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 3){
                    Intent intent = new Intent(v.getContext(),NewProduct4.class);
                    v.getContext().startActivity(intent);
                }
                if(position == 4){
                    Intent intent = new Intent(v.getContext(),NewProduct5.class);
                    v.getContext().startActivity(intent);
                }
            }
        });
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
    @Override
    public int getCount() {
        return sliderImageId.length;
    }
}
