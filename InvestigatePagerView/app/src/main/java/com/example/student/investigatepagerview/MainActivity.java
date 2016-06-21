package com.example.student.investigatepagerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

public class MainActivity extends FragmentActivity
{
    private static final int PAGE_COUNT = 64001;
    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final PageFragment pageFragment = new PageFragment();
        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        pager.addOnPageChangeListener(new OnPageChangeListener()
        {
            @Override
           public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
//                Log.d("MMM", "state " + state);
//                Log.d("MMM", "onPageScrollStateChanged > Page_count " + PAGE_COUNT);
//                if(0 != state)
//                {
//                    index = state;
//                }
//                else if(1 == index)
//                {
//                    int currentItem = pager.getCurrentItem();
//                    if (0 == currentItem)
//                    {
//                        pagerAdapter.instantiateItem(pager, pageFragment.getImagesLength() - 1);
//                        pager.setCurrentItem(pageFragment.getImagesLength() - 1);
//                        pageFragment.setForce(pageFragment.getImagesLength() - 1);
//                    }
//                }
            }
        });
    }


    private class MyFragmentPagerAdapter extends FragmentStatePagerAdapter
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
    }
*/
}