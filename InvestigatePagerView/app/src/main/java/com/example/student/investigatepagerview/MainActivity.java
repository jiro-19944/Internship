package com.example.student.investigatepagerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

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

        pager.addOnPageChangeListener(new OnPageChangeListener()
        {
            @Override
           public void onPageSelected(int position) {
                Log.d("MMM", "onPageSelected");
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("MMM", "onPageScrolled");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("MMM", "onPageScrollStateChanged > " + state);

                int index = pager.getCurrentItem();
                Log.d("MMM", "index = " + index);
                Log.d("MMM", "PAGE_COUT = " + PAGE_COUNT);
                if (index == PAGE_COUNT - 1) {
                    pagerAdapter.instantiateItem(pager, 0);
                    pager.setCurrentItem(0);
                }
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
            Log.d("MMM", ">>> 0position = " + position);
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