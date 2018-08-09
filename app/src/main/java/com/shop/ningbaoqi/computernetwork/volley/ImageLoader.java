package com.shop.ningbaoqi.computernetwork.volley;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.shop.ningbaoqi.computernetwork.R;

/**
 * ImageLoader加载图片会先显示默认的图片，等待图片加载完成才会显示在ImageView上
 */
public class ImageLoader extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatImageView iv = findViewById(R.id.iv);
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
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(iv, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        imageLoader.get("http://p1.so.qhimgs1.com/t01e3f49861bf9d046d.jpg", listener);
    }
}
