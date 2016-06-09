package com.example.student.investigatepagerview;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class DownSide extends AppCompatActivity
{

    private int width;
    private int height;

    private ViewGroup.MarginLayoutParams lowerLayoutDimens;
    private RelativeLayout lowerLayout;
    private ImageView currentImageView;
    private ImageView nextImageView;
    private ImageView prevImageView;
    private ImageView mainImageView;



    public DownSide(int width, int height, ImageView currentImageView, ImageView nextImageView, ImageView prevImageView, RelativeLayout lowerLayout)
    {
        this.width = width;
        this.height = height;
        this.currentImageView = currentImageView;
        this.nextImageView = nextImageView;
        this.prevImageView = prevImageView;

        this.lowerLayoutDimens = (ViewGroup.MarginLayoutParams) lowerLayout.getLayoutParams();
        this.lowerLayout = lowerLayout;

    }

    public void lowerLayout()
    {
        lowerLayoutDimens.topMargin = height / 3;
        lowerLayout.setLayoutParams(lowerLayoutDimens);
    }
}