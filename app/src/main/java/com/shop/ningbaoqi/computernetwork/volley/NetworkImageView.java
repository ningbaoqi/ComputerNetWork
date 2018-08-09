package com.shop.ningbaoqi.computernetwork.volley;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.shop.ningbaoqi.computernetwork.R;

public class NetworkImageView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkImageView imageView = findViewById(R.id.iv);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        ImageLoader imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });
        imageView.setDefaultImageResId(R.mipmap.ic_launcher);
        imageView.setErrorImageResId(R.mipmap.ic_launcher);
        imageView.setImageUrl("http://p1.so.qhimgs1.com/t01e3f49861bf9d046d.jpg", imageLoader);
    }
}
