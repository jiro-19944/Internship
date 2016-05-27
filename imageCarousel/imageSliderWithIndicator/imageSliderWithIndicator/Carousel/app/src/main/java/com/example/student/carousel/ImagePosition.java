package com.example.student.carousel;


import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImagePosition extends AppCompatActivity
{
    private int width;
    private int height;
    private int currentImageLeft;
    private int currentImageTop;
    private int currentImageRight;
    private int nextImageLeft;
    private int nextImageTop;
    private int nextImageBottom;
    private int prevImageTop;
    private int prevImageRight;
    private int prevImageBottom;


    public ImagePosition(int width, int height)
    {
        this.width = width;
        this.height = height;

        this.currentImageLeft = 0;
        this.currentImageTop = 0;
        this.currentImageRight = 0;

        this.prevImageTop = 0;
        this.prevImageRight = 0;
        this.prevImageBottom = 0;

        this.nextImageLeft = 0;
        this.nextImageTop = 0;
        this.nextImageBottom = 0;
    }

    public void setCurrentImagePosition(ImageView currentImageView, int rotation)
    {
        ViewGroup.MarginLayoutParams currentImageDimens = (ViewGroup.MarginLayoutParams) currentImageView.getLayoutParams();

        if(0 == rotation || 2 == rotation)
        {
            PortraitCurrentImagePosition();
        }
        else if(1 == rotation || 3 == rotation)
        {
            landscdapeCurrentImagePosition();
        }

        System.out.println("------  width  -------- " + width);
        System.out.println("------  height -------- " + height);

        currentImageDimens.leftMargin = currentImageLeft;
        currentImageDimens.topMargin = currentImageTop;
        currentImageDimens.rightMargin = currentImageRight;

        currentImageView.setLayoutParams(currentImageDimens);
    }

    public void setNextImagePosition(ImageView nextImageView, int rotation)
    {
        ViewGroup.MarginLayoutParams nextImageDimens = (ViewGroup.MarginLayoutParams) nextImageView.getLayoutParams();

        if(0 == rotation || 2 == rotation)
        {
            NextImagePositionlandscdapeOrPortrait(width, height);
        }
        else if(1 == rotation || 3 == rotation)
        {
            NextImagePositionlandscdapeOrPortrait(height, width);
        }

        nextImageDimens.leftMargin = nextImageLeft;
        nextImageDimens.topMargin = nextImageTop;
        nextImageDimens.bottomMargin = nextImageBottom;

        nextImageView.setLayoutParams(nextImageDimens);

    }

    public void setPrevImagePosition(ImageView prevImageView, int rotation)
    {
        ViewGroup.MarginLayoutParams prevImageDimens = (ViewGroup.MarginLayoutParams) prevImageView.getLayoutParams();

        if(0 == rotation || 2 == rotation)
        {
            PrevImagePositionlandscdapeOrPortrait(width, height);
        }
        else if(1 == rotation || 3 == rotation)
        {
            PrevImagePositionlandscdapeOrPortrait(height, width);
        }

        prevImageDimens.topMargin = prevImageTop;
        prevImageDimens.rightMargin = prevImageRight;
        prevImageDimens.bottomMargin = prevImageBottom;

        prevImageView.setLayoutParams(prevImageDimens);
    }

    private void PortraitCurrentImagePosition()
    {
        currentImageLeft = width / 5;
        currentImageTop = 3 * height / 7;
        currentImageRight = width / 5;
    }

    public void landscdapeCurrentImagePosition()
    {
        currentImageLeft = width / 3;
        currentImageTop = height / 5;
        currentImageRight = width / 3;
    }

    private void NextImagePositionlandscdapeOrPortrait(int width, int height)
    {
        nextImageLeft = 5 * width / 8;
        nextImageTop = height / 5;
        nextImageBottom = 15 * height / 34;

    }

    private void PrevImagePositionlandscdapeOrPortrait(int width, int height)
    {
        prevImageTop = height / 5;
        prevImageRight = 5 * width / 8;
        prevImageBottom = 15 * height / 34;
    }
}
