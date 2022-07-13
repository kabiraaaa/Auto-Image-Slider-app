package com.example.auto_image_slider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher imgswitcher;
    int imagelist[] = {R.drawable.jordan1,R.drawable.jordan2, R.drawable.jordan3, R.drawable.jordan4, R.drawable.jordan5};
    int count = imagelist.length;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        imgswitcher = findViewById(R.id.imgswitcher);
        imgswitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageview = new ImageView(getApplicationContext());
                imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageview;
            }
        });
        imgswitcher.setImageResource(imagelist[0]);


        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                currentIndex++;
                if(currentIndex == count)
                    currentIndex = 0;
                imgswitcher.setImageResource(imagelist[currentIndex]);
                handler.postDelayed(this,2000);
            }
        };
        handler.post(runnable);
    }
}