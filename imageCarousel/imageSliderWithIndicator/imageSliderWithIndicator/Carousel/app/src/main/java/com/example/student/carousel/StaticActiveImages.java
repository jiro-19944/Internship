package com.example.student.carousel;

import android.app.Fragment;
import android.os.Bundle;

public class StaticActiveImages extends Fragment {

    // data object we want to retain
    private int[] data;

    // this method is only called once for this fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int[] getData() {
        return data;
    }
}