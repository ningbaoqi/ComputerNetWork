package com.shop.ningbaoqi.computernetwork.retrofit;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface UploadFileForPart {
    @Multipart//表示允许多个@Part
    @POST("user/photo")
    Call<User> updateUser(@PartMap Map<String , RequestBody> photos, @Part("description")RequestBody description);
}
