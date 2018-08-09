package com.shop.ningbaoqi.computernetwork.httpURLConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionActivity extends AppCompatActivity {
    private static final String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1522642227474&di=494f214077d93f6246d647ce70956d1c&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%253D580%2Fsign%3D19fc584ff0d3572c66e29cd4ba126352%2F58aaab0a19d8bc3ea218096c808ba61ea8d3452a.jpg";
    private ImageView imageView;
    private Bitmap bitmap = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net1);
        imageView = (ImageView) findViewById(R.id.imageview);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0x123:
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                    break;
            }
        }
    };

    public void click(View view) {
        try {
            final URL url = new URL(path);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();//获取客户端和服务器的连接对象，此时还没有建立连接
                        connection.setRequestMethod("GET");//设置HTTP请求方式。注意请求方式要大写
                        connection.setConnectTimeout(5000);
                        connection.setReadTimeout(5000);
                        connection.connect();//发送请求，与服务器建立连接
                        if (connection.getResponseCode() == 200) {//如果连接的返回状态码是 200 则说明连接成功，并且服务器会以流的方式传递数据
                            InputStream inputStream = connection.getInputStream();//获取服务器响应头中的流，流中的数据就是客户端请求的数据
                            bitmap = BitmapFactory.decodeStream(inputStream);//将流中的内容解析成Bitmap对象
                            handler.sendEmptyMessage(0x123);
                            inputStream.close();
                        }
                        connection.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}