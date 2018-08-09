package com.shop.ningbaoqi.computernetwork.httpURLConnection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.shop.ningbaoqi.computernetwork.R;

public class Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpUtils.sendHttpRequest(address, new HttpCallbackListener() {//这两个方法最终还是在子线程中运行的，因此我们不可以在这里执行任何的UI操作，如果需要根据返回的结果来更新UI，则仍然要使用异步消息处理机制；
            @Override
            public void onFinish(String response) {
                //这里根据返回内容执行具体的逻辑
            }

            @Override
            public void onError(Exception e) {
                //在这里进行异常处理
            }
        });
    }
}
