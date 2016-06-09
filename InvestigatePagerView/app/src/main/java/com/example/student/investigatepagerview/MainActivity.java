package com.example.student.investigatepagerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends FragmentActivity
{
    private static int PAGE_COUNT;
    private static int width;
    private static int height;


    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PageFragment pageFragment = new PageFragment();
        PAGE_COUNT = pageFragment.getImagesLength();

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

//----------------- get Display metrics -----------------------
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        height = metrics.heightPixels;

//----------------- get images from XML by id ---------------------

        RelativeLayout upperLayout = (RelativeLayout) findViewById(R.id.main_layout);
        ImageView currentImageView = (ImageView) findViewById(R.id.currentImageView);
        ImageView nextImageView = (ImageView) findViewById(R.id.nextImageView);
        ImageView prevImageView = (ImageView) findViewById(R.id.prevImageView);

//------------------ set upper layout --------------------------------

        UpperSide upperSide = new UpperSide(width, height, upperLayout);
        upperSide.upperLayout();

        pager.setOnPageChangeListener(new OnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter
    {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return getPAGE_COUNT();
        }

    }

    public static  void setPAGE_COUNT(int pageCount)
    {
        PAGE_COUNT = pageCount;
    }

    public static int getPAGE_COUNT()
    {
        return PAGE_COUNT;
    }

    public static int getHeight()
    {
        return height;
    }

    public static int getWidth()
    {
        return width;
    }

}