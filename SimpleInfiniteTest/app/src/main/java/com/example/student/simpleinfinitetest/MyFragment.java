package com.example.student.simpleinfinitetest;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MyFragment extends Fragment
{
    private static int[] images = { R.drawable.img1,
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
    public static Fragment newInstance(MainActivity context, int pos)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", pos);
        bundle.putFloat("scale", MainActivity.scale);
        return Fragment.instantiate(context, MyFragment.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (container == null)
        {
            return null;
        }
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.fragment, container, false);

        int pos = this.getArguments().getInt("pos");
        ImageView firstImage = (ImageView) layout.findViewById(R.id.firstImage);

        Drawable image = getResources().getDrawable(images[pos]);
        int h = image.getIntrinsicHeight();
        int w = image.getIntrinsicWidth();
/*        Log.d("log", "image .... " + pos + "- rd  =  "+ w);
        Log.d("log", "image .... " + pos + "- rd  =  "+ h);*/
        firstImage.setImageResource(images[pos]);

        return layout;
    }

    public static int getImagesLength()
    {
        return images.length;
    }
}