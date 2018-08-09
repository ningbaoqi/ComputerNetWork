package com.shop.ningbaoqi.computernetwork.asyncHttpClient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.shop.ningbaoqi.computernetwork.R;

public class AsyncFramework1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String path = "http://192.168.13.13/Web/servlet/CheckLogin";
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();//把要提交的数据封装成 RequestParams 对象
        params.add("name", "姓名");
        params.add("pass", "密码");
        client.post(path, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(AsyncFramework1Activity.this , responseBody.toString() , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(AsyncFramework1Activity.this , responseBody.toString() , Toast.LENGTH_LONG).show();
            }
        });
    }
}

