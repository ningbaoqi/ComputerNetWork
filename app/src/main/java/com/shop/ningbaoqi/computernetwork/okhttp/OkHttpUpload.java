package com.shop.ningbaoqi.computernetwork.okhttp;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class OkHttpUpload extends AppCompatActivity {
    public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String filePath = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            filePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            return;
        }
        File file = new File(filePath, "wangshu.txt");
        okhttp3.Request request = new okhttp3.Request.Builder().url("https://api.github.com/markdown/raw").post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file)).build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                Log.d("nbq", response.body().string());
            }
        });
    }
}
