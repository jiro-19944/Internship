package com.example.student.carousel;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;


public class MainActivity extends AppCompatActivity {
    float fromPosition;
    float toPosition;
    int index = 0;
    int[] layouts = {};
    ImageView img = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*viewFlipper = (ViewFlipper) this.findViewById(R.id.backgroundViewFlipper);

        fade_in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        fade_out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);

        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);*/

        //sets auto flipping
        /*viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.startFlipping();*/


//-----------------------------------------------------------------------------------------------



//        ViewFlipper mainFliper = (ViewFlipper) findViewById(R.id.backgroundViewFlipper);
//        if (mainFliper != null) {
//            mainFliper.setOnTouchListener(this);
//        }
//
//        // Получаем объект ViewFlipper
//        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.backgroundViewFlipper);
//
//        // Создаем View и добавляем их в уже готовый flipper
//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//        for (int layout : layouts)
//            if (flipper != null) {
//                flipper.addView(inflater.inflate(layout, null));
//            }
        /*viewFlipper.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                System.out.println("--------------- on click");
                final ImageView img =  (ImageView) findViewById(R.id.bckgrndImageView8);
                if(index > 5)
                {
                    index = 0;
                }
                img.setImageResource(layouts[index]);
                ++index;
            }
        });*/
        layouts = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};
        img =  (ImageView) findViewById(R.id.bckgrndImageView8);
    }

    public boolean onTouch(MotionEvent event)
    {

        switch (event.getAction())
        {

            case MotionEvent.ACTION_UP:
                toPosition = event.getX();
                if (fromPosition > toPosition)
                {
                    --index;
                    if(index < 0)
                    {
                        index = layouts.length - 1;
                    }
                    img.setImageResource(layouts[index]);
                }
                else if (fromPosition < toPosition)
                {
                    ++index;
                    if(index > (layouts.length - 1))
                    {
                        index = 0;
                    }
                    img.setImageResource(layouts[index]);
                }
                break;
            default:
                break;
        }
        return true;
    }
}
