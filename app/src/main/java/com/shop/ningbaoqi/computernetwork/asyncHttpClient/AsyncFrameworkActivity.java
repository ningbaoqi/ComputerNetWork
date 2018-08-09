package com.shop.ningbaoqi.computernetwork.asyncHttpClient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.shop.ningbaoqi.computernetwork.R;

import java.net.URLEncoder;

public class AsyncFrameworkActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 使用 异步HTTP框架进行get请求
         * */
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        String path = "http://192.168.13.13/Web/servlet/CheckLogin?name=" + URLEncoder.encode("用户名") + "&pass=" + URLEncoder.encode("密码");
        asyncHttpClient.get(path, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {//请求服务器成功时，即响应码是200时 ， 此方法调用成功
                Toast.makeText(AsyncFrameworkActivity.this, responseBody.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {//请求失败时 即响应码不是200时 此方法调用
                Toast.makeText(AsyncFrameworkActivity.this, responseBody.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
