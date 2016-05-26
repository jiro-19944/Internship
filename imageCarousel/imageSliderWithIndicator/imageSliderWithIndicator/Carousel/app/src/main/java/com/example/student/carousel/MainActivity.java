package com.example.student.carousel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity
{
    private int selectedTest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//----------------- find relativeLayout by id ---------------------

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.main_layout);

//---------------- get screen sizies in pixels----------------------

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int width = metrics.widthPixels;
        int height = metrics.heightPixels;




//-----------------  Current image ---------------------

        ImageView thisImageView = (ImageView) findViewById(R.id.this_image_view);
        ViewGroup.MarginLayoutParams thisImageDimens = (ViewGroup.MarginLayoutParams) thisImageView.getLayoutParams();

        int thisImageLeft = width / 5;
        int thisImageTop = 6 * height / 11;
        int thisImageRight = width / 5;
      //  int thisImageBottom = 23;

        thisImageDimens.leftMargin = thisImageLeft;
        thisImageDimens.topMargin = thisImageTop;
        thisImageDimens.rightMargin = thisImageRight;
       // thisImageDimens.bottomMargin = thisImageBottom;

        thisImageView.setLayoutParams(thisImageDimens);



//-----------------  Next image ---------------------


//
//        ImageView nextImageView = (ImageView) findViewById(R.id.next_image_view);
//        ViewGroup.MarginLayoutParams nextImageDimens = (ViewGroup.MarginLayoutParams) nextImageView.getLayoutParams();
//
//        int nextImageLeft = width / 5;
//        int nextImageTop = 6 * height / 11;
//        int nextImageRight = width / 5;
//        //  int nextImageBottom = 23;
//
//        nextImageDimens.leftMargin = nextImageLeft;
//        nextImageDimens.topMargin = nextImageTop;
//        nextImageDimens.rightMargin = nextImageRight;
//        // nextImageDimens.bottomMargin = nextImageBottom;
//
//        nextImageView.setLayoutParams(nextImageDimens);



//-----------------  Prev image ---------------------


//
//        ImageView prevImageView = (ImageView) findViewById(R.id.prev_image_view);
//        ViewGroup.MarginLayoutParams prevImageDimens = (ViewGroup.MarginLayoutParams) prevImageView.getLayoutParams();
//
//        int prevImageLeft = width / 5;
//        int prevImageTop = 6 * height / 11;
//        int prevImageRight = width / 5;
//        //  int prevImageBottom = 23;
//
//        prevImageDimens.leftMargin = prevImageLeft;
//        prevImageDimens.topMargin = prevImageTop;
//        prevImageDimens.rightMargin = prevImageRight;
//        // prevImageDimens.bottomMargin = prevImageBottom;
//
//        prevImageView.setLayoutParams(prevImageDimens);
//
//



//
//        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
//        RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
//        RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
//        RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
//        RadioButton radio4 = (RadioButton) findViewById(R.id.radio4);
//        RadioButton radio5 = (RadioButton) findViewById(R.id.radio5);
//
//        OnTouch onTouch = new OnTouch(thisImageView, relativeLayout, nextImageView, prevImageView,
//                                        radioGroup, radio1, radio2, radio3, radio4, radio5);
//        onTouch.getOnTouch();
//        //onTouch.imageFromRadioButton();
    }
}


