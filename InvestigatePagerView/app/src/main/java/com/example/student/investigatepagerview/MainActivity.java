package com.example.student.investigatepagerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class MainActivity extends FragmentActivity
{
    private static int PAGE_COUNT;

    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PageFragment pageFragment = new PageFragment();
        PAGE_COUNT = pageFragment.getImagesLength();

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

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

        @Override
        public CharSequence getPageTitle(int position) {
            return "Image " + position;
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
}