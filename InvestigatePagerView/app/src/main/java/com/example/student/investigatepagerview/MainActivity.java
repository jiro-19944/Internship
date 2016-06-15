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
    private static final int PAGE_COUNT = 64000;
    private int index = 0;
    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PageFragment pageFragment = new PageFragment();
        //PAGE_COUNT = Integer.MAX_VALUE - pageFragment.getImagesLength() * (Integer.MAX_VALUE / pageFragment.getImagesLength());

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        pager.addOnPageChangeListener(new OnPageChangeListener()
        {
            @Override
           public void onPageSelected(int position) {

                //Log.d("MMM", "onPageSelected " + position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //Log.d("MMM", "onPageScrolled " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
                Log.d("MMM", "onPageScrollStateChanged > " + pager.getCurrentItem());
                Log.d("MMM", "onPageScrollStateChanged > Page_count " + PAGE_COUNT);
                if(0 != state)
                {
                    index = state;
                }
                else if(1 == index)
                {
                    int currentItem = pager.getCurrentItem();
                    if (PAGE_COUNT - 1 == currentItem)
                    {
                        pagerAdapter.instantiateItem(pager, 0);
                        pager.setCurrentItem(0);
                    }
                    else if(0 == currentItem)
                    {
                        pagerAdapter.instantiateItem(pager, PAGE_COUNT - 1);
                        pager.setCurrentItem(PAGE_COUNT - 1);
                    }
                }
//
//                int index = pager.getCurrentItem();
////                Log.d("MMM", "index = " + index);
////                Log.d("MMM", "PAGE_COUT = " + PAGE_COUNT);
//                if (index == PAGE_COUNT - 1) {
////                    pagerAdapter.instantiateItem(pager, 0);
////                    pager.setCurrentItem(0);
//                }
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
            //Log.d("MMM", ">>> 0position = " + position);
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Image " + position;
        }

    }
/*
    public static  void setPAGE_COUNT(int pageCount)
    {
        PAGE_COUNT = pageCount;
    }

    public static int getPAGE_COUNT()
    {
        return PAGE_COUNT;
    }*/
}