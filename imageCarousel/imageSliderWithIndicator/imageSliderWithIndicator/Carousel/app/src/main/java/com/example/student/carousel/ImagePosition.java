package com.example.student.carousel;


import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImagePosition extends AppCompatActivity
{
    private double width;
    private double height;
    private ViewGroup.MarginLayoutParams currentImageDimens;
    private ViewGroup.MarginLayoutParams nextImageDimens;
    private ViewGroup.MarginLayoutParams prevImageDimens;
    private ImageView currentImageView;
    private ImageView nextImageView;
    private ImageView prevImageView;

    public ImagePosition(double width, double height, ImageView currentImageView, ImageView nextImageView, ImageView prevImageView)
    {
        this.width = width;
        this.height = height;
        this.currentImageView = currentImageView;
        this.nextImageView = nextImageView;
        this.prevImageView = prevImageView;
        this.currentImageDimens = (ViewGroup.MarginLayoutParams) currentImageView.getLayoutParams();
        this.nextImageDimens = (ViewGroup.MarginLayoutParams) nextImageView.getLayoutParams();
        this.prevImageDimens = (ViewGroup.MarginLayoutParams) prevImageView.getLayoutParams();
    }

    public void countOfImages()
    {
        if (width / height < 1.5)
        {
            oneImagePosition();
        }
        else if(width / height >= 1.5 && width / height < 2.5)
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
        currentImageView.setLayoutParams(currentImageDimens);
    }

    private void twoImagesPosition()
    {
        currentImageDimens.rightMargin = (int) width / 2;
        nextImageDimens.leftMargin = (int) width / 2;
        prevImageDimens.leftMargin = (int) width;
        currentImageView.setLayoutParams(currentImageDimens);
        nextImageView.setLayoutParams(nextImageDimens);
        prevImageView.setLayoutParams(prevImageDimens);
    }

    private void threeImagesPosition()
    {
        currentImageDimens.leftMargin = (int) width / 3;
        currentImageDimens.rightMargin = (int) width / 3;
        nextImageDimens.leftMargin = (int) (2 * width / 3);
        nextImageDimens.rightMargin = 0;
        prevImageDimens.rightMargin = (int) (2 * width / 3);
        prevImageDimens.leftMargin = 0;
        currentImageView.setLayoutParams(currentImageDimens);
        nextImageView.setLayoutParams(nextImageDimens);
        prevImageView.setLayoutParams(prevImageDimens);
    }
}
