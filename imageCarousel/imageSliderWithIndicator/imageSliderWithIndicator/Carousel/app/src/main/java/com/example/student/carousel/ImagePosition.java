package com.example.student.carousel;


import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImagePosition extends AppCompatActivity
{
    private int width;
    private int height;

    public ImagePosition(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void setCurrentImagePosition(ImageView currentImageView)
    {
        ViewGroup.MarginLayoutParams currentImageDimens = (ViewGroup.MarginLayoutParams) currentImageView.getLayoutParams();

        int currentImageLeft = width / 5;
        int currentImageTop = 6 * height / 14;
        int currentImageRight = width / 5;

        currentImageDimens.leftMargin = currentImageLeft;
        currentImageDimens.topMargin = currentImageTop;
        currentImageDimens.rightMargin = currentImageRight;

        currentImageView.setLayoutParams(currentImageDimens);
    }

    public void setNextImagePosition(ImageView nextImageView)
    {
        ViewGroup.MarginLayoutParams nextImageDimens = (ViewGroup.MarginLayoutParams) nextImageView.getLayoutParams();

        int nextImageLeft = width / 2 + width / 8;
        int nextImageTop = height / 5;
        int nextImageBottom = height / 2 - height / 17;

        nextImageDimens.leftMargin = nextImageLeft;
        nextImageDimens.topMargin = nextImageTop;
        nextImageDimens.bottomMargin = nextImageBottom;

        nextImageView.setLayoutParams(nextImageDimens);

    }

    public void setPrevImagePosition(ImageView prevImageView)
    {
        ViewGroup.MarginLayoutParams prevImageDimens = (ViewGroup.MarginLayoutParams) prevImageView.getLayoutParams();

        int prevImageTop = height / 5;
        int prevImageRight = width / 2 + width / 8;
        int prevImageBottom = height / 2 - height / 17;

        prevImageDimens.topMargin = prevImageTop;
        prevImageDimens.rightMargin = prevImageRight;
        prevImageDimens.bottomMargin = prevImageBottom;

        prevImageView.setLayoutParams(prevImageDimens);
    }
}
