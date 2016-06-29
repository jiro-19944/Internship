package com.example.student.simpleinfinitetest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class MyPagerAdapter extends FragmentStatePagerAdapter implements ViewPager.OnPageChangeListener
{
    private MainActivity context;

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
        return "Image " + (position % MyFragment.getImagesLength() + 1);
    }

    @Override
    public float getPageWidth(int position)
    {
        float pageWidth = 0;

        if(MainActivity.layoutWidth / (1.0 *  (MainActivity.layoutHeight - MainActivity.pagerTabStrip)) < 1)
        {
            pageWidth = 1f;
        }
        else if(MainActivity.layoutWidth / (1.0 *  (MainActivity.layoutHeight - MainActivity.pagerTabStrip)) >= 1 && MainActivity.layoutWidth / (1.0 *  (MainActivity.layoutHeight - MainActivity.pagerTabStrip)) < 2)
        {
            pageWidth = 1f / (MainActivity.layoutWidth / MainActivity.layoutHeight) * 1f;
        }
        else
        {
            pageWidth = 1f / (MainActivity.layoutWidth / MainActivity.layoutHeight) * 1f;
        }
        MyFragment.setPageWidth(pageWidth * MainActivity.layoutWidth);

        return(pageWidth);
    }

}