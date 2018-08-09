package com.shop.ningbaoqi.computernetwork.retrofit;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IpServiceForPost {
    @FormUrlEncoded//表明这是一个表单请求
    @POST("getIpInfo.php")
    Call<Ipmodel> getIpMsg(@Field("ip") String first);//@Field("ip")标识所对应的String类型数据的键，从而组成一组键值对进行传递
}
