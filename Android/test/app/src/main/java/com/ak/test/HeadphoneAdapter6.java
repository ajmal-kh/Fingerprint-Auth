package com.ak.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HeadphoneAdapter6 extends PagerAdapter {
    View view;
    Context context;
    HeadphoneAdapter6(Context context){
        this.context = context;
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((ImageView) object);
    }

    private int[] sliderImageId = new int[]{
            R.drawable.headphone6a,R.drawable.headphone6b,R.drawable.headphone6c,R.drawable.headphone6d,R.drawable.headphone6e,R.drawable.headphone6f,R.drawable.headphone6g
    };

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(sliderImageId[position]);
        ((ViewPager) container).addView(imageView,0);
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
