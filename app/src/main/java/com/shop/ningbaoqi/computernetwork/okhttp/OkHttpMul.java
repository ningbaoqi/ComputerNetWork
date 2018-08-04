package com.shop.ningbaoqi.computernetwork.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class OkHttpMul extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)//第二个参数是上传文件的名字，第三个参数是需要上传的文件
                .addFormDataPart("title", "wangsu").addFormDataPart("image", "wangsu.jpg", RequestBody.create(MEDIA_TYPE_PNG, new File("/sdcard/wangsu.jpg")))
                .build();
        okhttp3.Request request = new okhttp3.Request.Builder().header("Authorization", "Client-ID" + "...").url("https://api.imgur.com/3/image").post(requestBody).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
            }
        });
    }
}