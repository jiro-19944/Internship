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

        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.main_layout);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
        RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
        RadioButton radio4 = (RadioButton) findViewById(R.id.radio4);
        RadioButton radio5 = (RadioButton) findViewById(R.id.radio5);

        OnTouch onTouch = new OnTouch(imageView, relativeLayout, radioGroup, radio1, radio2, radio3, radio4, radio5);
        onTouch.getOnTouch();
        onTouch.imageFromRadioButton();
    }
}


