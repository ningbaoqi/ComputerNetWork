package com.shop.ningbaoqi.computernetwork.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.shop.ningbaoqi.computernetwork.R;

import retrofit2.Retrofit;

public class RP extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://ip.taobao.com/service/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        IpServiceForPostBody ipServiceForPostBody = retrofit.create(IpServiceForPostBody.class);
        Call<Ipmodel> call = ipServiceForPostBody.getIpMsg(new Ip("59.108.54.37"));
        call.enqueue(new Callback<Ipmodel>() {
            @Override
            public void onResponse(Call<Ipmodel> call, Response<Ipmodel> response) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Ipmodel> call, Throwable t) {

            }
        });
    }
}
