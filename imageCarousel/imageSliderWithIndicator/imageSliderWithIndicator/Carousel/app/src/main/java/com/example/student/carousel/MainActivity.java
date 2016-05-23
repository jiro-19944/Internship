package com.example.student.carousel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.main_layout);
        ImageView thisImageView = (ImageView) findViewById(R.id.this_image_view);
        ImageView nextImageView = (ImageView) findViewById(R.id.next_image_view);
        ImageView prevImageView = (ImageView) findViewById(R.id.prev_image_view);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
        RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);

        OnTouch onTouch = new OnTouch(thisImageView, relativeLayout, nextImageView, prevImageView,
                                        radioGroup, radio1, radio2, radio3);
        onTouch.getOnTouch();
        //onTouch.imageFromRadioButton();
    }
}


