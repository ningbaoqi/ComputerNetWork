package com.shop.ningbaoqi.computernetwork.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.shop.ningbaoqi.computernetwork.R;

import retrofit2.Retrofit;

public class RetrofitGet extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://ip.taobao.com/service/";//retrofit请求的url是拼接出来的 http://ip.taobao.com/service/getIpInfo.php?ip=59.108.54.37
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                //增加返回值为JSON的支持
                .addConverterFactory(GsonConverterFactory.create()).build();
        IpService ipService = retrofit.create(IpService.class);
        Call<Ipmodel> call = ipService.getIpMsg();
        call.enqueue(new Callback<Ipmodel>() {//运行在UI线程，如果想同步请求网络使用call.execute(),如果想中断网络请求使用call.cancel()
            @Override
            public void onResponse(Call<Ipmodel> call, Response<Ipmodel> response) {
                String country = response.toString();
                Toast.makeText(getApplicationContext() , country , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Ipmodel> call, Throwable t) {

            }
        });
    }
}
