package com.example.student.carousel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;


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

        layouts = new int[]{R.drawable.img1,
                            R.drawable.img2,
                            R.drawable.img3,
                            R.drawable.img4,
                            R.drawable.img5,
                            R.drawable.img6};
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
