package com.example.student.carousel;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ArrayList activeImages = new ArrayList<>();
    private int activeIndex;
    private OnTouch onTouch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//----------------- set activeImages from XML ---------------------

        getImagesFromResources();

//----------------- get images from XML by id ---------------------

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.main_layout);
        ImageView currentImageView = (ImageView) findViewById(R.id.current_image_view);
        ImageView nextImageView = (ImageView) findViewById(R.id.next_image_view);
        ImageView prevImageView = (ImageView) findViewById(R.id.prev_image_view);

//----------------- get Display metrics -----------------------
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

//----------------- get Display rotation -----------------------

        Display display = ((WindowManager) this.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int rotation = display.getRotation();

//------------------ set images positions --------------------------------

        ImagePosition imagePosition = new ImagePosition(width, height);
        imagePosition.setCurrentImagePosition(currentImageView, rotation);
        imagePosition.setNextImagePosition(nextImageView, rotation);
        imagePosition.setPrevImagePosition(prevImageView, rotation);

//------------------- get radio group and radio buttons from XML by id ---------------------------------

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        RadioButton radio1 = (RadioButton) findViewById(R.id.radio1);
        RadioButton radio2 = (RadioButton) findViewById(R.id.radio2);
        RadioButton radio3 = (RadioButton) findViewById(R.id.radio3);
        RadioButton radio4 = (RadioButton) findViewById(R.id.radio4);
        RadioButton radio5 = (RadioButton) findViewById(R.id.radio5);

//---------------------- swapping images  -----------------------------------

        onTouch = new OnTouch(relativeLayout, currentImageView, nextImageView, prevImageView,
                radioGroup, radio1, radio2, radio3, radio4, radio5, getActiveImages(), getActiveIndex());
        onTouch.getOnTouch();
        //onTouch.imageFromRadioButton();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        setActiveImagesMain(onTouch.getActiveImages());
        outState.putIntegerArrayList("ACTIVE_IMAGES", activeImages);

        setActiveIndexMain(onTouch.getActiveIndex());
        outState.putInt("ACTIVE_INDEX", activeIndex);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        activeImages = savedInstanceState.getIntegerArrayList("ACTIVE_IMAGES");
        onTouch.setActiveImages(activeImages);

        activeIndex = savedInstanceState.getInt("ACTIVE_INDEX");
        onTouch.setActiveIndex(activeIndex);

        onTouch.getOnTouch();
    }

    private void getImagesFromResources()
    {
        String[] array = getResources().getStringArray(R.array.images);
        for(String a : array)
        {
            int imageId = getResources().getIdentifier(a, "drawable" , getPackageName());
            activeImages.add(imageId);
        }

    }

    public void setActiveImagesMain(ArrayList images)
    {
        this.activeImages = images;
    }

    public void setActiveIndexMain(int index) {
        this.activeIndex = index;
    }

    private ArrayList getActiveImages()
    {
        return this.activeImages;
    }

    private int getActiveIndex()
    {
        return this.activeIndex;
    }
}