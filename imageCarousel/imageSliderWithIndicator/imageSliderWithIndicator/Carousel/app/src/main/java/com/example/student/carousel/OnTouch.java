package com.example.student.carousel;

import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import java.util.ArrayList;

public class OnTouch extends AppCompatActivity
{
    private RelativeLayout relativeLayout;
    private ImageView currentImageView;
    private ImageView prevImageView;
    private ImageView nextImageView;
    private RadioGroup radioGroup;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private RadioButton radio5;
    private float fromPosition;
    private float toPosition;
    private ArrayList images;
    private int index;
    private int nextIndex;
    private int prevIndex;

    OnTouch(RelativeLayout relativeLayout, ImageView currentImageView, ImageView nextImageView, ImageView prevImageView, RadioGroup radioGroup, RadioButton r1,
            RadioButton r2, RadioButton r3, RadioButton r4, RadioButton r5, ArrayList images , int index)
    {
        this.relativeLayout = relativeLayout;
        this.currentImageView = currentImageView;
        this.nextImageView = nextImageView;
        this.prevImageView = prevImageView;
        this.radioGroup = radioGroup;
        this.radio1 = r1;
        this.radio2 = r2;
        this.radio3 = r3;
        this.radio4 = r4;
        this.radio5 = r5;
        this.images = images;
        this.index = index;
        this.nextIndex = index + 1;
        this.prevIndex = index - 1;
    }

    public void getOnTouch()
    {
        verifyIndexes();
        showImages();
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
                                verifyIndexes();
                                showImages();
                                radioButtonFromImage("next");
                            }
                            else if (fromPosition < toPosition)
                            {
                                --index;
                                verifyIndexes();
                                showImages();
                                radioButtonFromImage("prev");
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

    private void verifyIndexes()
    {
        index = testIndex(index);
        nextIndex = testIndex(index + 1);
        prevIndex = testIndex(index - 1);
    }

    private int testIndex(int index)
    {
        if (index > (getLenghtImages() - 1))
        {
            index = 0;
        }
        else if (index < 0)
        {
            index = (getLenghtImages() - 1);
        }
        return index;
    }

    private void showImages()
    {
        currentImageView.setImageResource((int)images.get(index));
        nextImageView.setImageResource((int)images.get(nextIndex));
        prevImageView.setImageResource((int)(images.get(prevIndex)));
    }

    public void radioButtonFromImage(String action)
    {
        switch (action)
        {
            case "next":
                if(radioGroup.getCheckedRadioButtonId() == radio1.getId())
                {
                    radio2.setChecked(true);
                }
                else if(radioGroup.getCheckedRadioButtonId() == radio2.getId())
                {
                    radio3.setChecked(true);
                }
                else if(radioGroup.getCheckedRadioButtonId() == radio3.getId())
                {
                    radio4.setChecked(true);
                }
                firstLastRadioButton();
                break;
            case "prev":
                if(radioGroup.getCheckedRadioButtonId() == radio5.getId())
                {
                    radio4.setChecked(true);
                }
                else if(radioGroup.getCheckedRadioButtonId() == radio4.getId())
                {
                    radio3.setChecked(true);
                }
                else if(radioGroup.getCheckedRadioButtonId() == radio3.getId())
                {
                    radio2.setChecked(true);
                }
                firstLastRadioButton();
                break;
            default:
                break;
        }
    }

    private void firstLastRadioButton()
    {
        if(0 == index)
        {
            radio1.setChecked(true);
        }
        else if(getLenghtImages() - 1 == index)
        {
            radio5.setChecked(true);
        }
    }

    public int getLenghtImages()
    {
        return this.images.size();
    }

    public void setImages(ArrayList images)
    {
        this.images = images;
    }

    public ArrayList getImages()
    {
        return this.images;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return this.index;
    }
}
