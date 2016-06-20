package net.leolink.android.simpleinfinitecarousel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
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
        position = position % MainActivity.PAGES;
		return MyFragment.newInstance(context, position);
	}

	@Override
	public int getCount()
	{		
		return MainActivity.PAGES * MainActivity.LOOPS;
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){}

	@Override
	public void onPageSelected(int position) {}

	@Override
	public void onPageScrollStateChanged(int state) {}
}