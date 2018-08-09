package com.shop.ningbaoqi.computernetwork.retrofit;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IpServiceForPath {
    @GET("{path}/getIpInfo.php?ip=59.108.54.37")
    Call<Ipmodel> getIpMsg(@Path("path") String path);//path配置其中的path
}
