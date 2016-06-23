package com.example.student.simpleinfinitetest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class MyPagerAdapter extends FragmentStatePagerAdapter implements ViewPager.OnPageChangeListener
{
    private MainActivity context;
    private static float pageWidth;

    public MyPagerAdapter(MainActivity context, FragmentManager fm)
    {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        position = position % MyFragment.getImagesLength() ;
        return MyFragment.newInstance(context, position);
    }

    @Override
    public int getCount()
    {
        return MyFragment.getImagesLength()  * MainActivity.loops;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {}

    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public CharSequence getPageTitle(int position) {
        return "Image " + (position % MyFragment.getImagesLength());
    }

/*
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
}*/
    @Override
    public float getPageWidth(int position) {
        if(MainActivity.layoutWidth / MainActivity.layoutHeight < 1.5)
        {
            pageWidth = 1f;
        }
        else if(MainActivity.layoutWidth / MainActivity.layoutHeight >= 1.5 && MainActivity.layoutWidth / MainActivity.layoutHeight < 2.5)
        {
            pageWidth = 0.5f;
        }
        else
        {
            pageWidth = 1f / 3f;
        }
        return(pageWidth);
    }
}