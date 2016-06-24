package com.example.student.simpleinfinitetest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends FragmentActivity
{
/*
    You can choose a bigger number for LOOPS, but you know, nobody will fling
    more than 1000 times just in order to test your "infinite" ViewPager :D
*/
    public final static int loops = 1000;
    public final static int firstPage = MyFragment.getImagesLength() * loops / 2;
    public final static float scale = 1.0f;
    public static int layoutWidth = 0;
    public static int layoutHeight = 0;


    public MyPagerAdapter adapter;
    public ViewPager pager;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.include_in);

        RelativeLayout layout = (RelativeLayout)findViewById(R.id.custom_layout);
/*
        ----------------- get Layout metrics -----------------------
*/
        layout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        layoutWidth = layout.getMeasuredWidth();
        layoutHeight = layout.getMeasuredHeight();

        pager = (ViewPager) findViewById(R.id.myviewpager);
/*
        ----------------- set pager metrics -----------------------

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) pager.getLayoutParams();
        params.width = layoutWidth;
        params.height = layoutHeight;
        Log.d("log", "width  .... " + params.width);
        Log.d("log", "height .... " + params.height);
*/

        adapter = new MyPagerAdapter(this, this.getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(adapter);
/*
         Set current item to the middle page so we can fling to both
         directions left and right
*/
        pager.setCurrentItem(firstPage);
/*
         Necessary or the pager will only have one extra page to show
         make this at least however many pages you can see
*/
        pager.setOffscreenPageLimit(1);
/*
         Set margin for pages as a negative number, so a part of next and
         previous pages will be showed
*/
    }
}