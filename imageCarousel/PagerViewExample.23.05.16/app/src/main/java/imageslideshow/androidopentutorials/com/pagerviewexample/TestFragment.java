package imageslideshow.androidopentutorials.com.pagerviewexample;

/**
 * Created by nanenare on 5/22/16.
 */
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.util.Random;

public final class TestFragment extends Fragment {
    //private static final String KEY_CONTENT = "TestFragment:Content";
    private String mContent = " ";
    public static ImageView newImage ;
    private int res ;



    public static TestFragment newInstance(int image) {
        TestFragment fragment = new TestFragment();
        System.out.println("---------------image--------------  " + image);

//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < 8; ++i) {
//            builder.append(images).append(" ");
//        }
//        builder.deleteCharAt(builder.length() - 1);
        fragment.res = image;
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
//            mContent = savedInstanceState.getString(KEY_CONTENT);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ImageView img = new ImageView(getActivity());
//        img.FOCUSABLES_TOUCH_MODE(CursorAdapter);
//
//        img.setText(mContent);
//        img.setTextSize(18 * getResources().getDisplayMetrics().density);
        System.out.println("---------------res--------------  " + res);
        System.out.println("---------------R.drawable.img1--------------  " + R.drawable.img1);
        img.setBackgroundResource(res);
        img.setPadding(20, 20, 20, 20);

        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        layout.setGravity(Gravity.CENTER);
        layout.addView(img);
//        Random rnd = new Random();
//        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//        layout.setBackgroundColor(color);
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString(KEY_CONTENT, mContent);
    }
}