//package com.example.student.investigatepagerview;
//
//import android.os.Bundle;
//import android.support.v4.view.PagerTabStrip;
//import android.support.v7.app.AppCompatActivity;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//
//public class UpperSide extends AppCompatActivity
//{
//    private int width;
//    private int height;
//
//    private ViewGroup.MarginLayoutParams upperLayoutDimens;
//    private ViewGroup.MarginLayoutParams currentImageViewDimens;
//    private ViewGroup.MarginLayoutParams pagerTabStripDimens;
//
//    private RelativeLayout upperLayout;
//    private ImageView currentImageView;
//
//    public UpperSide(int width, int height, RelativeLayout upperLayout, ImageView currentImageView)
//    {
//        this.width = width;
//        this.height = height;
//
//        this.upperLayoutDimens = (ViewGroup.MarginLayoutParams) upperLayout.getLayoutParams();
//        this.currentImageViewDimens = (ViewGroup.MarginLayoutParams) currentImageView.getLayoutParams();
//
//        this.upperLayout = upperLayout;
//        this.currentImageView = currentImageView;
//    }
//
//    public void upperLayout()
//    {
//        upperLayoutDimens.bottomMargin = 0;
//        upperLayout.setLayoutParams(upperLayoutDimens);
//
//        currentImageViewDimens.topMargin = 7 * height / 10;
//        currentImageViewDimens.bottomMargin = height / 35;
//        currentImageView.setLayoutParams(currentImageViewDimens);
//    }
//}