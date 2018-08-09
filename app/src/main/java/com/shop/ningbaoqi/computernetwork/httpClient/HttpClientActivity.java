package com.shop.ningbaoqi.computernetwork.httpClient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.InputStream;
import java.net.URLEncoder;

import okhttp3.internal.http.StatusLine;

public class HttpClientActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 使用 HttpClient 框架，实现使用 HTTP协议 进行 GET 提交 ,只要是 GET 请求都需要在 URL 后面进行拼接
         * */
        new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "http://192.168.13.13/Web/servlet/CheckLogin?name=" + URLEncoder.encode("用户名") + "&pass=" + URLEncoder.encode("密码");//url的长度要在2048字符之内，http1.1之后长度才没有限制
                HttpClient client = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(path);
                try {
                    HttpResponse response = client.execute(httpGet);//使用客户端对象，将 get 请求发送出去 ， 产生网络交互
                    StatusLine statusLine = response.getStatusLine();//拿到响应头中的状态行
                    if (statusLine.getStatusCode() == 200) {
                        HttpEntity entity = response.getEntity();//拿到响应头的实体
                        InputStream inputStream = entity.getContent();//拿到实体中的内容，其实就是服务器返回的输入流
                        String text = Utils.getTextFromStream(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
