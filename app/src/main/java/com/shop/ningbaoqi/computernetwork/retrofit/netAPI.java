package com.shop.ningbaoqi.computernetwork.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface netAPI {
    @GET("repos/{owner}/{repo}/contributors")//定义的是URL,动态获取URL
    Call<ResponseBody> contributorsBySimpleGetCall(@Path("owner") String owner, @Path("repo") String repo);
}
