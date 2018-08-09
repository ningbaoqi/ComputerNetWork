package com.shop.ningbaoqi.computernetwork.retrofit;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

public class RPUPload extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://ip.taobao.com/service/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        File file = new File(Environment.getExternalStorageDirectory(), "wangshu.png");
        RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part photo = MultipartBody.Part.createFormData("photots", "wangshu.png", photoRequestBody);
        UploadFileForPart uploadFileForPart = retrofit.create(UploadFileForPart.class);
        Call<User> call = uploadFileForPart.updateUser(photo, RequestBody.create(null, "wangshu"));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
