package com.shop.ningbaoqi.computernetwork.okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 第一步：创建OkHttpClient对象，全局的实例进行保存，在App的各处只要使用这一个实例对象就可以，所有的http请求可以共用response缓存和线程池
 * 第二步：创建Request对象；
 * 第三步：获取响应
 */
public class OkHttpDemo {
    private final OkHttpClient client = new OkHttpClient();

    /**
     * 同步请求
     *
     * @throws Exception
     */
    public void okhttpSyncGet() throws Exception {
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        Response response = client.newCall(request).execute();//同步获取数据，会阻塞当前线程
        if (!response.isSuccessful()) {
            throw new IOException("");
        }
        Headers headers = response.headers();//获取请求头
        for (int i = 0; i < headers.size(); i++) {
            headers.name(i);//头部的名字
            headers.value(1);//头部的数据
        }
        response.body().string();//响应体
    }

    /**
     * 异步获取数据,不会阻塞当前线程
     *
     * @throws Exception
     */
    public void okhttpAsyGet() throws Exception {
        Request request = new Request.Builder().url("http://www.baiduy.com").build();
        client.newCall(request).enqueue(new Callback() {//异步获取数据
            @Override
            public void onFailure(Call call, IOException e) {//工作线程中执行的
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {//在UI线程中执行
                if (!response.isSuccessful()) {
                    throw new IOException("");
                }
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    headers.name(i);
                    headers.value(i);
                }
                response.body().string();
            }
        });
    }
}
