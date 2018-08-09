package com.shop.ningbaoqi.computernetwork.httpClient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shop.ningbaoqi.computernetwork.R;

import java.io.InputStream;

public class HttpClient2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "http://192.168.13.13/Web/servlet/CheckLogin";//POST请求都不需要在URL上拼接数据
                HttpClient client = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost();
                try {
                    BasicNameValuePair pair = new BasicNameValuePair("name", "myname");//设置 POST 请求的实体，其实就是把要提交的数据封装到 POST 请求的输出流中
                    BasicNameValuePair pair1 = new BasicNameValuePair("pass", "mypassword");
                    List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
                    list.add(pair);
                    list.add(pair1);
                    UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");//将数据放在实体对象中，并且设置编码格式
                    httpPost.setEntity(encodedFormEntity);
                    HttpResponse response = client.execute(httpPost);//使用客户端发送POST请求
                    if (response.getStatusLine().getStatusCode() == 200) {
                        InputStream inputStream = response.getEntity().getContent();
                        String text = Utils.getTextFromStream(inputStream);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
