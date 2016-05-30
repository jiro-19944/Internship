package com.example.student.carousel;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity
{
    private int[] activeImages = {R.drawable.img1,
                                R.drawable.img2,
                                R.drawable.img3,
                                R.drawable.img4,
                                R.drawable.img5,
                                R.drawable.img6,
                                R.drawable.img7,
                                R.drawable.img8,
                                R.drawable.img9,
                                R.drawable.img10,
                                R.drawable.bob1,
                                R.drawable.bob2,
                                R.drawable.bob3};;

   private StaticActiveImages dataFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the retained fragment on activity restarts

        FragmentManager fm = getFragmentManager();
        dataFragment = (StaticActiveImages) fm.findFragmentByTag("data");

        // create the fragment and data the first time
        if (dataFragment == null)
        {
            // add the fragment
            dataFragment = new StaticActiveImages();
            fm.beginTransaction().add(dataFragment, "data").commit();
            // load the data from the web
            dataFragment.setData(getActiveImages());
        }

//----------------- get images from XML by id ---------------------

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.main_layout);
        ImageView currentImageView = (ImageView) findViewById(R.id.current_image_view);
        ImageView nextImageView = (ImageView) findViewById(R.id.next_image_view);
        ImageView prevImageView = (ImageView) findViewById(R.id.prev_image_view);


        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        System.out.println("----------------  width  -----------" + width);
        System.out.println("----------------  height  -----------" + height);

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



//---------------------- create OnTouch object -----------------------------------

        OnTouch onTouch = new OnTouch(currentImageView, relativeLayout, nextImageView, prevImageView,
                radioGroup, radio1, radio2, radio3, radio4, radio5/*, StaticActiveImages.activeImages*/, dataFragment.getData());
        onTouch.getOnTouch();
        //setActiveImages(onTouch.getActiveImages());
        //onTouch.imageFromRadioButton();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        // store the data in the fragment
        dataFragment.setData(getActiveImages());
    }

    private int[] getActiveImages()
    {
        return this.activeImages;
    }

    public void setActiveImages(int[] images)
    {
        System.out.println("--------------------  arjeqavorum -------------------");
        System.out.println("--------------------  ekaci andamner -------------------" + images[0]);


        this.activeImages = images;
        System.out.println("--------------------  tvaci andamner -------------------" + activeImages[0]);

    }
}



