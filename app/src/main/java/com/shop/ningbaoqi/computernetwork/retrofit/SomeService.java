package com.shop.ningbaoqi.computernetwork.retrofit;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface SomeService {
    @GET("some/endpoint")
    @Headers("Accept-Encoding:application/json")
    Call<RequestBody> getCarType();
}
