package com.example.student.carousel;

import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class OnTouch extends AppCompatActivity
{
    private float fromPosition;
    private float toPosition;
    private int index;
    private int[] images;
    private ImageView imgageView;
    RelativeLayout relativeLayout;
    RadioGroup radioGroup;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioButton radio4;
    RadioButton radio5;

    OnTouch(ImageView imageView, RelativeLayout relativeLayout, RadioGroup radioGroup, RadioButton r1,
            RadioButton r2, RadioButton r3, RadioButton r4, RadioButton r5)
    {
        this.index = 4;
        this.images = new int[]{R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img6,
                R.drawable.img7};
        this.imgageView = imageView;
        this.relativeLayout = relativeLayout;
        this.radioGroup = radioGroup;
        this.radio1 = r1;
        this.radio2 = r2;
        this.radio3 = r3;
        this.radio4 = r4;
        this.radio5 = r5;
    };

    public void getOnTouch()
    {
        if (relativeLayout != null)
        {
            relativeLayout.setOnTouchListener(new RelativeLayout.OnTouchListener()
            {
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    switch (event.getAction())
                    {
                        case MotionEvent.ACTION_DOWN:
                            fromPosition = event.getX();
                            break;
                        case MotionEvent.ACTION_UP:
                            toPosition = event.getX();
                            if (fromPosition > toPosition)
                            {
                                ++index;
                                if(index > (getLenghtImages() - 1))
                                {
                                    index = 0;
                                }
                                imgageView.setImageResource(images[index]);
                                radioButtonFromImage(index);
                            }
                            else if (fromPosition < toPosition)
                            {
                                --index;
                                if(index < 0)
                                {
                                    index = (getLenghtImages() - 1);
                                }
                                imgageView.setImageResource(images[index]);
                                radioButtonFromImage(index);
                            }
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
        }
    }

    public void radioButtonFromImage(int index)
    {
        if(0 == index)
        {
            radio1.setChecked(true);
        }
        else if(1 == index) {
            radio2.setChecked(true);
        }
        else if((getLenghtImages() - 1) == index)
        {
            radio5.setChecked(true);
        }
        else if((getLenghtImages() - 2) == index)
        {
            radio4.setChecked(true);
        }
        else
        {
            radio3.setChecked(true);
        }
    }

    public void imageFromRadioButton()
    {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                View radioButton = radioGroup.findViewById(checkedId);
                int i = radioGroup.indexOfChild(radioButton);

                if(0 == i)
                {
                    //radio1.setChecked(true);
                    imgageView.setImageResource(images[i]);
                    index = i;
                }
                else if(1 == i)
                {
                    //radio2.setChecked(true);
                    imgageView.setImageResource(images[i]);
                    index = i;
                }
                else if(2 == i)
                {
                    //radio3.setChecked(true);
                    imgageView.setImageResource(images[getHalfOfLenghtImages()]);
                    index = getHalfOfLenghtImages();
                }
                else if(3 == i)
                {
                    //radio4.setChecked(true);
                    imgageView.setImageResource(images[getLenghtImages() - 2]);
                    index = getLenghtImages() - 2;
                }
                else if(4 == i)
                {
                    //radio5.setChecked(true);
                    imgageView.setImageResource(images[getLenghtImages() - 1]);
                    index = getLenghtImages() - 1;
                }
            }
        });
    }

    public int getLenghtImages()
    {
        return this.images.length;
    }

    public int getHalfOfLenghtImages()
    {
        return (getLenghtImages() / 2 + 1);
    }
}
