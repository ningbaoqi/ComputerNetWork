package com.shop.ningbaoqi.computernetwork.retrofit;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface IpServiceForQueryMap {
    @GET("getIpInfo.php")
    Call<Ipmodel> getIpMsg(@QueryMap Map<String, String> ip);
}
