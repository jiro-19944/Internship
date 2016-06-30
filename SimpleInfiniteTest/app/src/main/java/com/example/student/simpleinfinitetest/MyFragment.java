package com.example.student.simpleinfinitetest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private static int cardWidth = 0;
    private static float cardHeight = 0;
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
                                    R.drawable.bob3,
                                    R.drawable.ic_launcher,
                                    R.drawable.img14,
                                    R.drawable.img15,
                                    R.drawable.img16,
                                    R.drawable.img17,
                                    R.drawable.img18};

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
/*
        Drawable image = getResources().getDrawable(images[pos]);
        int imageWidth = image.getIntrinsicWidth();
        int imageHeight = image.getIntrinsicHeight();
*/

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), images[pos]);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
/*


        Log.d("log", "bitmap ....  " + pos + "- rd  =  " + bitmapWidth);
        Log.d("log", "bitmap ....  " + pos + "- rd  =  " + bitmapHeight);
        Log.d("log", "cardWidth   .... " + pos + "- rd  =  " + cardWidth);
        Log.d("log", "cardHeight  .... " + pos + "- rd  =  " + cardHeight);
        Log.d("log", ".............................................");
*/

        int halfWidth = bitmapWidth / 2;
        int halfHeight = bitmapHeight / 2;

        if(bitmapWidth < bitmapHeight)
        {
            double k = cardWidth / bitmapWidth;
            Log.d("log", "............................................." + k);

        }

        Bitmap tmp = Bitmap.createBitmap(halfWidth, halfHeight, Bitmap.Config.ARGB_8888);
        int[] pixels = new int[halfWidth * halfHeight];

        bitmap.getPixels(pixels, 0, halfWidth, halfWidth , halfHeight , halfWidth, halfHeight);
        tmp.setPixels(pixels, 0, halfWidth, 0, 0, halfWidth, halfHeight);

        firstImage.setImageBitmap(tmp);

//        firstImage.setImageResource(images[pos]);

        return layout;
    }

    public static int getImagesLength()
    {
        return images.length;
    }

    public static float getPageWidth() {
        return cardWidth;
    }

    public static void setPageWidth(int pageWidth) {
        cardWidth = pageWidth;
    }

    public static float getPageHeight() {
        return cardHeight;
    }

    public static void setPageHeight(float pageHeight) {
        cardHeight = pageHeight;
    }
}