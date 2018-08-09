package com.shop.ningbaoqi.computernetwork.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 使用步骤：在retrofit中通过一个接口作为http请求的api接口->创建一个Retrofit实例->调用api接口
 */
public class RetrofitDemo {
    public void retrofitHttpRequest() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").build();//baseUrl是用来url拼接的，basseUrl不是完整的URL，在URL后面会加上GET属性当中的URL
        netAPI repo = retrofit.create(netAPI.class);
        retrofit2.Call<ResponseBody> call = repo.contributorsBySimpleGetCall("userName", "path");
        call.enqueue(new retrofit2.Callback<ResponseBody>() {//异步方法实现网络请求
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
