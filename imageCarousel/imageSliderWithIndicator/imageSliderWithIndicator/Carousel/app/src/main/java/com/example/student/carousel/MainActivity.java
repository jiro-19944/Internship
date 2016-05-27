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

//----------------- get images from XML by id ---------------------

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.main_layout);
        ImageView currentImageView = (ImageView) findViewById(R.id.current_image_view);
        ImageView nextImageView = (ImageView) findViewById(R.id.next_image_view);
        ImageView prevImageView = (ImageView) findViewById(R.id.prev_image_view);

//------------------ set images positions --------------------------------

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        ImagePosition imagePosition = new ImagePosition(width, height);
        imagePosition.setCurrentImagePosition(currentImageView);
        imagePosition.setNextImagePosition(nextImageView);
        imagePosition.setPrevImagePosition(prevImageView);

//------------------- get radio group and radio buttons from XML by id ---------------------------------


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
        RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
        RadioButton radio4 = (RadioButton) findViewById(R.id.radio4);
        RadioButton radio5 = (RadioButton) findViewById(R.id.radio5);

//---------------------- create OnTouch object -----------------------------------


        OnTouch onTouch = new OnTouch(currentImageView, relativeLayout, nextImageView, prevImageView,
                                        radioGroup, radio1, radio2, radio3, radio4, radio5);
        onTouch.getOnTouch();
        //onTouch.imageFromRadioButton();
    }
}


