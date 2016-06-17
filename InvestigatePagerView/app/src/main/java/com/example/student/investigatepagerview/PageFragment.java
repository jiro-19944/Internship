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
    private static int force = 0;
    private static int prevPageNumber = 0;
    private static boolean vkl = true;
    /*
    * force responsible for the display of images
    * vkl represents the transition to the right or left
    * */
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
        Log.d("MMM", "                 onViewCreate");
        View view = inflater.inflate(R.layout.fragment, null);
        ImageView mainImageView = (ImageView) view.findViewById(R.id.mainImageView);

        if (pageNumber % (getImagesLength()) == 0 && vkl)
        {
            force = 0;
        }

        Log.d("MMM", "                  kar                " );
        Log.d("MMM", "pagenumber = " + pageNumber);
        Log.d("MMM", "force = " + force);
        Log.d("MMM", "prevPageNumber = " + prevPageNumber);

        if(vkl)
        {
            mainImageView.setImageResource(images[force]);
        }
        if(pageNumber >= prevPageNumber)
        {
            vkl = true;
            ++force;
            if (pageNumber - prevPageNumber == 3) {
                force = force + 2;
            }

            if (force >= getImagesLength()) {
                force = force - getImagesLength();
                Log.d("MMM", " force > 11       ");
            }
            Log.d("MMM", " pageNumber >= prevPageNumber        ");
        }
        else if(prevPageNumber > pageNumber)
        {
            vkl = false;
            --force;
            if (prevPageNumber - pageNumber == 3) {
                force = force - 2;
            }
            Log.d("MMM", " prevPageNumber > pageNumber          ");

            if (force < 0) {
                force = force + getImagesLength();
                Log.d("MMM", " force < 0       ");
            }

        }
        if(!vkl)
        {
            if(force != 0)
            {
                mainImageView.setImageResource(images[force-1]);
            }
            else if(force == 0)
            {
                mainImageView.setImageResource(images[getImagesLength()-1]);
            }
        }
        prevPageNumber = pageNumber;

        Log.d("MMM", "                   darav            " );
        Log.d("MMM", "pagenumber = " + pageNumber);
        Log.d("MMM", "force = " + force);
        Log.d("MMM", "prevPageNumber = " + prevPageNumber);
        Log.d("MMM", "                                      ");

        return view;
    }

    public int getImagesLength()
    {
        return images.length;
    }

//    public void setForce(int tmpForce)
//    {
//        force = tmpForce;
//    }
}