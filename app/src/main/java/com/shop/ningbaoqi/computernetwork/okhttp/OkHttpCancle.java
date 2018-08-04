package com.shop.ningbaoqi.computernetwork.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class OkHttpCancle extends AppCompatActivity {
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpClient client = new OkHttpClient();
        final okhttp3.Request request = new okhttp3.Request.Builder().url("https://www.baidu.com").cacheControl(CacheControl.FORCE_NETWORK).build();
        Call call = null;
        call = client.newCall(request);
        final Call finalCall = call;
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                finalCall.cancel();
            }
        }, 1000, TimeUnit.MICROSECONDS);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                if (response.cacheResponse().toString() != null) {
                    Log.d("nbq", response.cacheResponse().toString());
                } else {
                    Log.d("nbq", response.networkResponse().toString());
                }
            }
        });
    }
}
