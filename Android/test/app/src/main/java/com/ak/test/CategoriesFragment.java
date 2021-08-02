package com.ak.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class CategoriesFragment extends Fragment {
    private LinearLayout mobileCategory, laptopCategory, speakerCategory, tvCategory, headphoneCategory, watchCategory;
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories,container,false);
        mobileCategory = (LinearLayout) view.findViewById(R.id.mobileCategory);
        laptopCategory = (LinearLayout) view.findViewById(R.id.laptopCategory);
        speakerCategory = (LinearLayout) view.findViewById(R.id.speakerCategory);
        tvCategory = (LinearLayout) view.findViewById(R.id.tvCategory);
        headphoneCategory = (LinearLayout) view.findViewById(R.id.headphoneCategory);
        watchCategory = (LinearLayout) view.findViewById(R.id.watchCategory);


        mobileCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MobileCategory.class);
                startActivity(intent);
            }
        });

        laptopCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LaptopCategory.class);
                startActivity(intent);
            }
        });
        speakerCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SpeakerCategory.class);
                startActivity(intent);
            }
        });
        tvCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TelevisionCategory.class);
                startActivity(intent);
            }
        });
        headphoneCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HeadphoneCategory.class);
                startActivity(intent);
            }
        });
        watchCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WatchCategory.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
