package com.example.student.simpleinfinite;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
                                    R.drawable.img10};
    public static Fragment newInstance(MainActivity context, int pos)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", pos);
        bundle.putFloat("scale", MainActivity.SCALE);
        return Fragment.instantiate(context, MyFragment.class.getName(), bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if (container == null)
        {
            Log.d("log","container == null .... ");
            return null;
        }
        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.fragment, container, false);

        int pos = this.getArguments().getInt("pos");
        ImageView firstImage = (ImageView) layout.findViewById(R.id.firstImage);
//        ImageView secondImage = (ImageView) layout.findViewById(R.id.secondImage);
//        ImageView thirdImage = (ImageView) layout.findViewById(R.id.thirdImage);
/*

        ImagePosition imagePosition = new ImagePosition(firstImage);
        imagePosition.countOfImages();
*/

        firstImage.setImageResource(images[pos]);

        Log.d("log", "position ... " + pos);
        return layout;
    }

    public static int getImagesLength()
    {
        return images.length;
    }
}