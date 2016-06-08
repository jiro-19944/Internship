package com.galust.slider.vanadzorimageslider.SliderTypes;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.galust.slider.vanadzorimageslider.MainActivity;
import com.galust.slider.vanadzorimageslider.R;

/**
 * This is a slider with a description TextView.
 */
public class TextSliderView extends BaseSliderView{
    public TextSliderView(MainActivity context) {
        super(context);
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.render_type_text,null);
        ImageView target = (ImageView)v.findViewById(R.id.galust_slider_image);
        TextView description = (TextView)v.findViewById(R.id.description);
        description.setText(getDescription());
        bindEventAndShow(v, target);
        return v;
    }
}
