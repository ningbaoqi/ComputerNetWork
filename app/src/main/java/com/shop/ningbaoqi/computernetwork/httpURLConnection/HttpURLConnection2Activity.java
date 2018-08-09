package com.shop.ningbaoqi.computernetwork.httpURLConnection;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnection2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "https://www.baidu.com/baidu.html";
                try {
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    connection.connect();
                    if (connection.getResponseCode() == 200) {
                        InputStream inputStream = connection.getInputStream();
                        String text = Utils.getTextFromStream(inputStream);
                        Message message = Message.obtain();
                        message.obj = text;
                        handler.sendMessage(message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(HttpURLConnection2Activity.this, msg.obj.toString(), Toast.LENGTH_LONG).show();
        }
    };
}
