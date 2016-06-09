package com.example.student.investigatepagerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class UpperSide extends AppCompatActivity
{
    private int width;
    private int height;

    private ViewGroup.MarginLayoutParams upperLayoutDimens;
    private RelativeLayout upperLayout;

    public UpperSide(int width, int height, RelativeLayout upperLayout)
    {
        this.width = width;
        this.height = height;

        this.upperLayoutDimens = (ViewGroup.MarginLayoutParams) upperLayout.getLayoutParams();
        this.upperLayout = upperLayout;
    }

    public void upperLayout()
    {
        upperLayoutDimens.bottomMargin = height / 3;
        upperLayout.setLayoutParams(upperLayoutDimens);
    }
}