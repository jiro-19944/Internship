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
    private ArrayList activeImages;
    private int[] images;
    private int activeIndex;

    OnTouch(RelativeLayout relativeLayout, ImageView currentImageView, ImageView nextImageView, ImageView prevImageView, RadioGroup radioGroup, RadioButton r1,
            RadioButton r2, RadioButton r3, RadioButton r4, RadioButton r5, ArrayList activeImages , int activeIndex)
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
        this.activeImages = activeImages;
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
        this.activeIndex = activeIndex;
    }

    public void getOnTouch()
    {
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
                                ++activeIndex;
                                verifyIndex();
                                activeImagesToLeft();
                                showImages();
                                radioButtonFromImage("next");
                                System.out.println("----------- activeIndex =     " + activeIndex);
                            }
                            else if (fromPosition < toPosition)
                            {
                                --activeIndex;
                                verifyIndex();
                                activeImagesToRight();
                                showImages();
                                radioButtonFromImage("prev");
                                System.out.println("----------- activeIndex =     " + activeIndex);
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

    private void activeImagesToLeft()
    {
        int tmp = (int) activeImages.get(0);
        for (int i = 0; i < getLenghtImages(); ++i)
        {
            activeImages.set(i , activeImages.get(i + 1));
            if(i + 1 == getLenghtImages() - 1)
            {
                activeImages.set(i + 1, tmp);
                break;
            }
        }
    }

    private void activeImagesToRight()
    {
        int tmp = (int)activeImages.get((int)(activeImages.size()-1));
        for (int i = getLenghtImages() - 1; i >= 0; --i)
        {
            activeImages.set(i, activeImages.get(i-1));
            if(i - 1 == 0)
            {
                activeImages.set(i-1, tmp);
                break;
            }
        }
    }

    private void verifyIndex()
    {
        if (activeIndex > (getLenghtImages() - 1))
        {
            activeIndex = 0;
        }
        else if (activeIndex < 0)
        {
            activeIndex = (getLenghtImages() - 1);
        }
    }

    private void showImages()
    {
        currentImageView.setImageResource((int)activeImages.get(0));
        nextImageView.setImageResource((int)activeImages.get(1));
        prevImageView.setImageResource((int)(activeImages.get((int) activeImages.size() - 1)));

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
        if(0 == activeIndex)
        {
            radio1.setChecked(true);
        }
        else if(getLenghtImages() - 1 == activeIndex)
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

    public void setActiveImages(ArrayList activeImages)
    {
        this.activeImages = activeImages;
    }

    public void setActiveIndex(int activeIndex)
    {
        this.activeIndex = activeIndex;
    }

    public ArrayList getActiveImages()
    {
        return this.activeImages;
    }

    public int getActiveIndex()
    {
        return this.activeIndex;
    }
}
