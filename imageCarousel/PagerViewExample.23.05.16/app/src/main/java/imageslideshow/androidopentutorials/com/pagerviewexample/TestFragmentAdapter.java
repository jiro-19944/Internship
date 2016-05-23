package imageslideshow.androidopentutorials.com.pagerviewexample;

import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;


public class TestFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
    protected static final int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
//    protected static final int[] ICONS = new int[] {
//    };

    private int mCount = images.length;

    public TestFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        System.out.println("---------------position--------------  " + position);
        // 2  -->  The activity has finished its creation.
        // 3  -->  Fully created, not started.
        return TestFragment.newInstance(images[position % images.length]);
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public int getIconResId(int index) {
        return 0;
    }

//    public void setCount(int count) {
//        if (count > 0 && count <= 10) {
//            mCount = count;
//            notifyDataSetChanged();
//        }
//    }
}