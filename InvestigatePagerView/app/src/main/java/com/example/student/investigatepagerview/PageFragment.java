package com.example.student.investigatepagerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PageFragment extends Fragment
{
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
        View view = inflater.inflate(R.layout.fragment, null);
        ImageView mainImageView = (ImageView) view.findViewById(R.id.mainImageView);

        MainActivity.setPAGE_COUNT(MainActivity.getPAGE_COUNT());
        mainImageView.setImageResource(images[pageNumber]);

        return view;
    }

    public int getImagesLength()
    {
        return images.length;
    }

}