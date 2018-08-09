package com.shop.ningbaoqi.computernetwork.httpURLConnection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpURLConnection3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 将用户名和密码放在URL的后面，表示URL表示的网络界面设置用户名和密码，进行GET请求发送数据到服务器，就可以接收到服务器的相应信息
                 +  提交的数据需要经过URL编码，英文和数字编码后不变，汉字会改变,所以都需要进行URL编码
                 * */
                String path = "http://192.168.1.220/Web2/servlet/LoginServlet?name=" + URLEncoder.encode("大会速度卡号") +"&pass=" + URLEncoder.encode("hdakhda");
                try {
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.connect();
                    if (connection.getResponseCode() == 200) {
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
