package com.shop.ningbaoqi.computernetwork.retrofit;

import retrofit2.http.GET;

public interface IpService {
    @GET("getIpInfo.php?ip=59.108.54.37")//请求的地址是getIpInfo.php?ip=59.108.54.37
    Call<Ipmodel> getIpMsg();
}
