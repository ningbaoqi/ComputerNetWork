package com.shop.ningbaoqi.computernetwork.retrofit;

import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IpServiceForPostBody {//用post方法将json字符串作为请求体发送到服务器

    @POST("getIpInfo.php")
    Call<Ipmodel> getIpMsg(@Body Ip ip);//用@Body这个注解标识参数对象即可，Retrofit会将IP对象转换为字符串
}

class Ip {
    private String ip;

    public Ip(String ip) {
        this.ip = ip;
    }
}