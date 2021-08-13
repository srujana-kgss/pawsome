package com.example.test;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;
//3b25b0ab-ba3e-4a3c-a571-3e9e6ef50be5
public interface Retrofitapi {
    @GET("v1/breeds?api_key=3b25b0ab-ba3e-4a3c-a571-3e9e6ef50be5")
    Call<List<dogbreedmodel>> getthem();

   @Multipart
    @POST("v1/images/upload?sub_id=USER-1&api-key=3b25b0ab-ba3e-4a3c-a571-3e9e6ef50be5")
    Call<ResponseBody> uploadImage(@Part MultipartBody.Part file );








}



