package com.example.student.simpleinfinite;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity
{
/*
     You can choose a bigger number for LOOPS, but you know, nobody will fling
     more than 1000 times just in order to test your "infinite" ViewPager :D
*/
    public final static int LOOPS = 1000;
    public final static int FIRST_PAGE = MyFragment.getImagesLength() * LOOPS / 2;
    public final static float BIG_SCALE = 1.0f;

    public MyPagerAdapter adapter;
    public ViewPager pager;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.myviewpager);

        adapter = new MyPagerAdapter(this, this.getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(adapter);

/*
         Set current item to the middle page so we can fling to both
         directions left and right
*/
        pager.setCurrentItem(FIRST_PAGE);

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
