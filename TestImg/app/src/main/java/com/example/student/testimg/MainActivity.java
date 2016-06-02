package com.example.student.testimg;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(" ==========================  main  ======================== ");

//__________________    Get image from XML by id    ____________________

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.main_layout);
        ImageView currentImageView = (ImageView) findViewById(R.id.current_image_view);

// __________________    Make a HashMap    ____________________

        Map<String, String> hm = new HashMap<String, String>();

        hm.put("img1", "http://detskiy-journal.ru/uploads/posts/2013-06/thumbs/1370676136_1.jpg");
        hm.put("img2", "http://detskiy-journal.ru/uploads/posts/2013-06/thumbs/1370676181_2.jpg");
        hm.put("img3", "http://detskiy-journal.ru/uploads/posts/2013-06/thumbs/1370676182_3.jpg");
        hm.put("img4", "http://detskiy-journal.ru/uploads/posts/2013-06/thumbs/1370676127_4.jpg");
        hm.put("img5", "http://detskiy-journal.ru/uploads/posts/2013-06/thumbs/1370676131_5.jpg");
        hm.put("img6", "http://detskiy-journal.ru/uploads/posts/2013-06/thumbs/1370676144_6.jpg");
        hm.put("img7", "http://detskiy-journal.ru/uploads/posts/2013-06/thumbs/1370676182_7.jpg");
        hm.put("img8", "http://detskiy-journal.ru/uploads/posts/2013-06/thumbs/1370676122_8.jpg");
        hm.put("img9", "http://detskiy-journal.ru/uploads/posts/2013-06/thumbs/1370676191_9.jpg");
        hm.put("img10", "http://detskiy-journal.ru/uploads/posts/2013-06/thumbs/1370676131_10.jpg");

// __________________    Get a set(array) of elements    ____________________

        Set<Map.Entry<String, String>> set = hm.entrySet();

// __________________    Display of set(array)     __________________________

        for (Map.Entry<String, String> me : set) {
            System.out.print(me.getKey() + "  :    ");
            System.out.println(me.getValue());
        }

//  __________________    Add the values     ________________________________

//        String value = hm.get("img5");
//        hm.put("img5", value +       200000);
//        System.out.println("-----------  img5 change ------ " + hm.get("img5"));

//        currentImageView.setImageResource(Integer.parseInt(hm.get("img5")));


        assert currentImageView != null;
//        currentImageView.setImageURI(URI.parse("file://mnt/sdcard/cat.jpg"));
//        currentImageView.setImageURI(Uri.parse(hm.get("img5")));
        currentImageView.setImageResource((int)images.get(0));


    }

}
