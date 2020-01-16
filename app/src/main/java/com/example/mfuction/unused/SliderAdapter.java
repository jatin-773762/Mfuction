package com.example.mfuction.unused;

import android.content.Context;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.mfuction.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context)
    {
        this.context=context;
    }
    public int[] slide_image={
            R.drawable.bbg,
            R.drawable.bbg,
            R.drawable.bbg,
            R.drawable.bbg,
            R.drawable.bbg


    };
    public String []slide_details={
            "Calculator","Musix","Quiz","Timer","Camera"


    };
    @Override
    public int getCount() {
        return slide_details.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(ConstraintLayout) object;


    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slider,container,false);

        ImageView sliderImageView=(ImageView)view.findViewById(R.id.imageView4);
        Button slider_detail=(Button)view.findViewById(R.id.txt_btn);

        sliderImageView.setImageResource(slide_image[position]);
        slider_detail.setText(slide_details[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object){
        container.removeView((LinearLayout)object);
    }
}
