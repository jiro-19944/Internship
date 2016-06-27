package com.example.student.simpleinfinitetest;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
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
    public static RelativeLayout layout;
    public static ViewTreeObserver.OnGlobalLayoutListener myOnGlobalLayoutListener;
/*
    public MyPagerAdapter adapter;
    public ViewPager pager;
*/

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Log.d("log", "onWindowFocusChanged   ............." );
        super.onWindowFocusChanged(hasFocus);
        myOnGlobalLayoutListener.onGlobalLayout();
    }

    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.include_in);

        layout = (RelativeLayout)findViewById(R.id.custom_layout);
        layout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        Log.d("log", "onCreate   ............." );

        myOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout()
            {
                if (Build.VERSION.SDK_INT<16) {
                    layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                layoutWidth  = layout.getMeasuredWidth();
                layoutHeight = layout.getMeasuredHeight();
                Log.d("log", "onGlobalLayout   .............layoutWidth  ...  " + layoutWidth);
                Log.d("log", "onGlobalLayout   .............layoutHeight ...  " + layoutHeight);
            }

        };

/*
        ----------------- get Layout metrics -----------------------

        layout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        layoutWidth = layout.getMeasuredWidth();
        layoutHeight = layout.getMeasuredHeight();
*/
/*
        layoutWidth = layout.getLayoutParams().width;
        layoutHeight = layout.getLayoutParams().height;

        return values is "-1` match_parent   or -2` wrap_content"
*/
        ViewPager pager = (ViewPager) findViewById(R.id.myviewpager);
/*
        ----------------- set pager metrics -----------------------

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) pager.getLayoutParams();
        params.width = layoutWidth;
        params.height = layoutHeight;
        Log.d("log", "width  .... " + params.width);
        Log.d("log", "height .... " + params.height);
*/

        MyPagerAdapter adapter = new MyPagerAdapter(this, this.getSupportFragmentManager());
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
/*    public int viewWidth(View view) {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        Log.d("log", "viewWidth   ............." + layoutWidth);
        return view.getMeasuredWidth();
    }*/
}