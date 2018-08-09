package com.shop.ningbaoqi.computernetwork.retrofit;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IpServiceForQuery {
    @GET("getIpInfo.php")
    Call<Ipmodel> getIpMsg(@Query("ip") String ip);
}
