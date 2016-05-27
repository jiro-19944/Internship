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
    private RelativeLayout relativeLayout;
    private float fromPosition;
    private float toPosition;
    private int index;
    private int nextIndex;
    private int prevIndex;
    private int[] images;
    private int[] activeImages;
    private ImageView currentImageView;
    private ImageView prevImageView;
    private ImageView nextImageView;
    private RadioGroup radioGroup;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private RadioButton radio5;

    OnTouch(ImageView currentImageView, RelativeLayout relativeLayout, ImageView nextImageView, ImageView prevImageView, RadioGroup radioGroup, RadioButton r1,
            RadioButton r2, RadioButton r3, RadioButton r4, RadioButton r5)
    {
        this.relativeLayout = relativeLayout;
        this.index = 0;
        this.nextIndex = index + 1;
        this.prevIndex = index - 1;
        this.images = new int[]{R.drawable.img1,
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
                                R.drawable.bob3};
        this.activeImages = new int[]{images[0], images[1], images[2]};
        this.currentImageView = currentImageView;
        this.nextImageView = nextImageView;
        this.prevImageView = prevImageView;
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
                                verifyIndex();
                                nextIndexFromIndex(index);
                                prevIndexFromIndex(index);
                                updateActiveImages();
                                showImages();
                                radioButtonFromImage("next");
                            }
                            else if (fromPosition < toPosition)
                            {
                                --index;
                                verifyIndex();
                                nextIndexFromIndex(index);
                                prevIndexFromIndex(index);
                                updateActiveImages();
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

    private void verifyIndex()
    {
        if (index > (getLenghtImages() - 1))
        {
            index = 0;
        }
        else if (index < 0)
        {
            index = (getLenghtImages() - 1);
        }
    }

    private void nextIndexFromIndex(int index)
    {
        nextIndex = index + 1;
        if(nextIndex > (getLenghtImages() - 1))
        {
            nextIndex = 0;
        }
    }

    private void prevIndexFromIndex(int index)
    {
        prevIndex = index - 1;
        if(prevIndex < 0)
        {
            prevIndex = (getLenghtImages() - 1);
        }
    }

    private void updateActiveImages()
    {
        activeImages[2] = images[nextIndex];
        activeImages[0] = images[prevIndex];
        activeImages[1] = images[index];
    }

    private void showImages()
    {
        currentImageView.setImageResource(activeImages[1]);
        nextImageView.setImageResource(activeImages[2]);
        prevImageView.setImageResource(activeImages[0]);

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

//    public void imageFromRadioButton()
//    {
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
//        {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId)
//            {
//                View radioButton = radioGroup.findViewById(checkedId);
//                int i = radioGroup.indexOfChild(radioButton);
//                if(0 == i)
//                {
//                    index = prevIndex;
//                    verifyIndex();
//                    nextIndexFromIndex(prevIndex);
//                    prevIndexFromIndex(prevIndex);
//                    updateActiveImages();
//                    showImages();
//                }
//                else if(1 == i)
//                {
//                    showImages();;
//                }
//                else if(2 == i)
//                {
//                    index = nextIndex;
//                    verifyIndex();
//                    prevIndexFromIndex(nextIndex);
//                    nextIndexFromIndex(nextIndex);
//                    updateActiveImages();
//                    showImages();
//                }
//            }
//        });
//    }

    public int getLenghtImages()
    {
        return this.images.length;
    }
}
