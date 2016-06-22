package com.example.student.simpleinfinite;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;

public class MainActivity extends FragmentActivity
{
/*
     You can choose a bigger number for LOOPS, but you know, nobody will fling
     more than 1000 times just in order to test your "infinite" ViewPager :D
*/
    public final static int LOOPS = 1000;
    public final static int FIRST_PAGE = MyFragment.getImagesLength() * LOOPS / 2;
    public final static float SCALE = 1.0f;
    public static double width = 0;
    public static double height = 0;

    public MyPagerAdapter adapter1;
//    public MyPagerAdapter adapter2;
//    public MyPagerAdapter adapter3;
    public static ViewPager pager1;
    public static ViewPager pager2;
    public static ViewPager pager3;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        ----------------- get Display metrics -----------------------
*/
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        height = metrics.heightPixels;

        pager1 = (ViewPager) findViewById(R.id.currentViewPager);
        pager2 = (ViewPager) findViewById(R.id.prevViewPager);
        pager3 = (ViewPager) findViewById(R.id.nextViewPager);

        adapter1 = new MyPagerAdapter(this, this.getSupportFragmentManager());
//        adapter2 = new MyPagerAdapter(this, this.getSupportFragmentManager());
//        adapter3 = new MyPagerAdapter(this, this.getSupportFragmentManager());

        pager1.setAdapter(adapter1);
        pager2.setAdapter(adapter1);
        pager3.setAdapter(adapter1);

        pager1.addOnPageChangeListener(adapter1);
        pager2.addOnPageChangeListener(adapter1);
        pager3.addOnPageChangeListener(adapter1);
/*
         Set current item to the middle page so we can fling to both
         directions left and right
*/
        pager1.setCurrentItem(FIRST_PAGE);
        pager2.setCurrentItem(FIRST_PAGE - 1);
        pager3.setCurrentItem(FIRST_PAGE + 1);
/*
         Necessary or the pager will only have one extra page to show
         make this at least however many pages you can see
*/
        pager1.setOffscreenPageLimit(1);
//        pager2.setOffscreenPageLimit(1);
//        pager3.setOffscreenPageLimit(1);
/*
         Set margin for pages as a negative number, so a part of next and
         previous pages will be showed
*/
    }
}
