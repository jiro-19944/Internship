package com.example.student.simpleinfinite;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
            R.drawable.img10};
    public static Fragment newInstance(MainActivity context, int pos)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", pos);
        bundle.putFloat("scale", MainActivity.BIG_SCALE);
        return Fragment.instantiate(context, MyFragment.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (container == null)
        {
            return null;
        }
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment, container, false);

        int pos = this.getArguments().getInt("pos");
        ImageView imageView = (ImageView) layout.findViewById(R.id.imageView);
        imageView.setImageResource(images[pos]);

        return layout;
    }

    public static int getImagesLength()
    {
        return images.length;
    }
}