package com.example.student.investigatepagerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PageFragment extends Fragment
{
//    private static final String TAG = PageFragment.class.getSimpleName();

    private int patik = 0;
    private static int force = 0;
    private static int nextOrPrevImage = 0;
    private static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    private int pageNumber;
    private int[] images = {R.drawable.img1,
                            R.drawable.img2,
                            R.drawable.img3,
                            R.drawable.img4,
                            R.drawable.img5,
                            R.drawable.img6,
                            R.drawable.img7,
                            R.drawable.img8,
                            R.drawable.img9,
                            R.drawable.img10,
                            R.drawable.bob3};

    static PageFragment newInstance(int page)
    {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Log.d("MMM", "onViewCreate");
        View view = inflater.inflate(R.layout.fragment, null);
        ImageView mainImageView = (ImageView) view.findViewById(R.id.mainImageView);

        if (pageNumber % (getImagesLength()) == 0)
        {
            force = 0;
//            Log.d("MMM", "patik = " + patik);
        }

        Log.d("MMM", "pagenumber = " + pageNumber);
        Log.d("MMM", "force = " + force);
        Log.d("MMM", "nextOrPrevImage = " + nextOrPrevImage);
        Log.d("MMM", "            1in blok  < < <              " );


        mainImageView.setImageResource(images[force]);
        if(pageNumber >= nextOrPrevImage)
        {
            ++force;
        }
        else
        {
            --force;
            if(force < 0)
            {
                force = getImagesLength() - 1;
            }
        }
        nextOrPrevImage = pageNumber;

        Log.d("MMM", "pagenumber = " + pageNumber);
        Log.d("MMM", "force = " + force);
        Log.d("MMM", "nextOrPrevImage = " + nextOrPrevImage);
        Log.d("MMM", "             > > > 2rd blok            " );

        return view;
    }

    public int getImagesLength()
    {
        return images.length;
    }

    public void setForce(int tmpForce)
    {
        force = tmpForce;
    }
}