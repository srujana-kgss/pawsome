package com.example.test;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiconfig {

    private static final String BASE_URL = "https://api.thedogapi.com/";

    private  static  apiconfig mInstance;
    private  Retrofit retrofit;
    private  apiconfig(){
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized apiconfig getInstance() {
        if (mInstance == null) {
            mInstance = new apiconfig();
        }
        return mInstance;
    }


    public Retrofitapi getAPI() {
        return retrofit.create(Retrofitapi.class);
    }


}



