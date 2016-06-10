package com.galust.slider.vanadzorimageslider;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.galust.slider.vanadzorimageslider.Animations.DescriptionAnimation;
import com.galust.slider.vanadzorimageslider.SliderTypes.BaseSliderView;
import com.galust.slider.vanadzorimageslider.SliderTypes.TextSliderView;
import com.galust.slider.vanadzorimageslider.Tricks.ViewPagerEx;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private SliderLayout mDemoSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        HashMap<String, String> url_maps = new HashMap<>();
        url_maps.put("Vanadzor centr", "http://vanadzor.ru/photo/vanadzor/gallery/20050601/10001.jpg");
        url_maps.put("Vanadzor hospital", "http://cs607124.vk.me/v607124114/24cc/GeOssO7EiZA.jpg");
        url_maps.put("Church","http://anitour.am/media/mediaelement/745/sanahin_monastery_1.jpg");
        url_maps.put("Culture house","http://photos.wikimapia.org/p/00/02/23/42/85_big.jpg");
        url_maps.put("Vanadzor governors hall","http://vanadzor.ru/photo/vanadzor/gallery/20040701/10001.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Vanadzori kulturai tun", R.drawable.vanadzorikulturaitun);
        file_maps.put("Vanadzori Marzpetarani Shenq", R.drawable.vanadzormarzpetaran);
        file_maps.put("Kayarani hraparak", R.drawable.kayaranihraparak);
        file_maps.put("Erekoyan Vanadzor", R.drawable.erekoyanvanadzor);


        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);

//            textSliderView
//                    .description(name)
//                    .image(url_maps.get(name))
//                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
//                    .setOnSliderClickListener(this);
            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.CubeIn);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();

        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Image Vanadzor", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}
