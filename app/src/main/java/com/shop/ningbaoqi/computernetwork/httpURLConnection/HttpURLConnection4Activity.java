package com.shop.ningbaoqi.computernetwork.httpURLConnection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpURLConnection4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * POST请求并不是在URL后面添加数据的，所以直接使用网址就可以
                 * */
                String path = "http://192.168.1.220/Web2/servlet/LoginServlet";
                try {
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    String data = "name=" + URLEncoder.encode("用户名") + "&pass=" + URLEncoder.encode("密码");//拼接出要提交的数据的字符串
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");//POST请求需要自己设置属性，请求头和数据，服务器上可以看出需要什么属性
                    connection.setRequestProperty("Content-Length", "" + data.length());
                    connection.setDoOutput(true);//设置打开输出流
                    OutputStream outputStream = connection.getOutputStream();//获取输出流
                    outputStream.write(data.getBytes());//向输出流中写入数据，目前还没有与服务器进行交互
                    if (connection.getResponseCode() == 200) {//与服务器进行交互
                        InputStream inputStream = connection.getInputStream();
                        String text = Utils.getTextFromStream(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
