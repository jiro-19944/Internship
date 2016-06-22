package com.example.student.simpleinfinite;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImagePosition extends AppCompatActivity
{
    private ViewPager.MarginLayoutParams pager1Dimens;
    private ViewPager.MarginLayoutParams pager2Dimens;
    private ViewPager.MarginLayoutParams pager3Dimens;
    private ViewPager pager1;
    private ViewPager pager2;
    private ViewPager pager3;

    public ImagePosition(ImageView currentImageView)
    {
        this.pager1 = MainActivity.pager1;
        this.pager2 = MainActivity.pager2;
        this.pager3 = MainActivity.pager3;

        this.pager1Dimens = (ViewGroup.MarginLayoutParams) currentImageView.getLayoutParams();
        this.pager2Dimens = (ViewGroup.MarginLayoutParams) currentImageView.getLayoutParams();
        this.pager3Dimens = (ViewGroup.MarginLayoutParams) currentImageView.getLayoutParams();
    }

    public void countOfImages()
    {
        if (MainActivity.width / MainActivity.height < 1.5)
        {
            oneImagePosition();
        }
        else if(MainActivity.width / MainActivity.height >= 1.5 && MainActivity.width / MainActivity.height < 2.5)
        {
            twoImagesPosition();
        }
        else
        {
            threeImagesPosition();
        }
    }

    private void oneImagePosition()
    {
        pager1.setLayoutParams(pager1Dimens);
    }

    private void twoImagesPosition()
    {
        pager1Dimens.rightMargin = (int) MainActivity.width / 2;
        pager2Dimens.leftMargin = (int) MainActivity.width;
        pager3Dimens.leftMargin = (int) MainActivity.width / 2;
        pager1.setLayoutParams(pager1Dimens);
        pager2.setLayoutParams(pager2Dimens);
        pager3.setLayoutParams(pager3Dimens);

    }

    private void threeImagesPosition()
    {
        pager1Dimens.leftMargin = (int) MainActivity.width / 3;
        pager1Dimens.rightMargin = (int) MainActivity.width / 3;
        pager3Dimens.leftMargin = (int) (2 * MainActivity.width / 3);
        pager3Dimens.rightMargin = 0;
        pager2Dimens.rightMargin = (int) (2 * MainActivity.width / 3);
        pager2Dimens.leftMargin = 0;
        pager1.setLayoutParams(pager1Dimens);
        pager2.setLayoutParams(pager2Dimens);
        pager3.setLayoutParams(pager3Dimens);
    }
}
