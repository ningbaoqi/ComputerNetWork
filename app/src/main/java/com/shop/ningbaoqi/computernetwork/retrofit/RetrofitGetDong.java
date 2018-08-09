package com.shop.ningbaoqi.computernetwork.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.shop.ningbaoqi.computernetwork.R;

import retrofit2.Retrofit;

public class RetrofitGetDong extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://ip.taobao.com/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        IpServiceForPath ipServiceForPath = retrofit.create(IpServiceForPath.class);
        Call<Ipmodel> call = ipServiceForPath.getIpMsg("service");
        call.enqueue(new Callback<Ipmodel>() {
            @Override
            public void onResponse(Call<Ipmodel> call, Response<Ipmodel> response) {
                String country = response.toString();
                Toast.makeText(getApplicationContext(), country, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Ipmodel> call, Throwable t) {

            }
        });
    }
}
