package com.example.student.simpleinfinitetest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MainActivity extends FragmentActivity
{
    public final static int loops = 1000;
    public final static int firstPage = MyFragment.getImagesLength() * loops / 2;
    public final static float scale = 1.0f;
    public static int layoutWidth = 0;
    public static int layoutHeight = 0;
    public static RelativeLayout layout;
    public static final float pagerTabStrip = 30;
    private ViewPager pager;
    private MyPagerAdapter adapter;

    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.include_in);

        layout = (RelativeLayout)findViewById(R.id.custom_layout);
        layout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) layout.getLayoutParams();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        layoutWidth = layout.getMeasuredWidth();
        layoutHeight = layout.getMeasuredHeight();

        if(layoutWidth == 0){
            layoutWidth = metrics.widthPixels;
            layoutWidth -= layoutParams.leftMargin;
            layoutWidth -= layoutParams.rightMargin;
        }
        if(layoutHeight == 0){
            layoutHeight = metrics.heightPixels;
            layoutHeight -= layoutParams.topMargin;
            layoutHeight -= layoutParams.bottomMargin;
        }

        MyFragment.setPageHeight(layoutHeight - pagerTabStrip);

        pager = (ViewPager) findViewById(R.id.myviewpager);

        adapter = new MyPagerAdapter(this, this.getSupportFragmentManager());

        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(adapter);
        pager.setCurrentItem(firstPage);
        pager.setOffscreenPageLimit(1);
    }
}