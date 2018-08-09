package com.shop.ningbaoqi.computernetwork.retrofit;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface SomeService2 {
    @GET("some/endpoint")
    Call<RequestBody> getCarType(@Header("Location") String location);
}
