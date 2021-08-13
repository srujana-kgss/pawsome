package com.example.test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class modelclass {



  // private static Retrofit retrofit;
  //  private static String BASE_URL = "https://api.thedogapi.com/";

  //  public static Retrofit getRetrofit() {
   //     OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
   //     if (retrofit == null) {
    //        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                 //   addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
   //     }
   //     return retrofit;
   // }

String id,url,sub_id,original_filename;
Integer width,height,pending,approved;

    public modelclass(String id, String url, String sub_id, String original_filename, Integer width, Integer height, Integer pending, Integer approved) {
        this.id = id;
        this.url = url;
        this.sub_id = sub_id;
        this.original_filename = original_filename;
        this.width = width;
        this.height = height;
        this.pending = pending;
        this.approved = approved;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getOriginal_filename() {
        return original_filename;
    }

    public void setOriginal_filename(String original_filename) {
        this.original_filename = original_filename;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
    }

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }


    //import javax.annotation.Generated;
    //import com.google.gson.annotations.Expose;
    //import com.google.gson.annotations.SerializedName;
    //
    //@Generated("jsonschema2pojo")
    //public class Example {
    //
    //@SerializedName("id")
    //@Expose
    //private String id;
    //@SerializedName("url")
    //@Expose
    //private String url;
    //@SerializedName("sub_id")
    //@Expose
    //private String subId;
    //@SerializedName("width")
    //@Expose
    //private Integer width;
    //@SerializedName("height")
    //@Expose
    //private Integer height;
    //@SerializedName("original_filename")
    //@Expose
    //private String originalFilename;
    //@SerializedName("pending")
    //@Expose
    //private Integer pending;
    //@SerializedName("approved")
    //@Expose
    //private Integer approved;
    //
    //public String getId() {
    //return id;
    //}
    //
    //public void setId(String id) {
    //this.id = id;
    //}
    //
    //public String getUrl() {
    //return url;
    //}
    //
    //public void setUrl(String url) {
    //this.url = url;
    //}
    //
    //public String getSubId() {
    //return subId;
    //}
    //
    //public void setSubId(String subId) {
    //this.subId = subId;
    //}
    //
    //public Integer getWidth() {
    //return width;
    //}
    //
    //public void setWidth(Integer width) {
    //this.width = width;
    //}
    //
    //public Integer getHeight() {
    //return height;
    //}
    //
    //public void setHeight(Integer height) {
    //this.height = height;
    //}
    //
    //public String getOriginalFilename() {
    //return originalFilename;
    //}
    //
    //public void setOriginalFilename(String originalFilename) {
    //this.originalFilename = originalFilename;
    //}
    //
    //public Integer getPending() {
    //return pending;
    //}
    //
    //public void setPending(Integer pending) {
    //this.pending = pending;
    //}
    //
    //public Integer getApproved() {
    //return approved;
    //}
    //
    //public void setApproved(Integer approved) {
    //this.approved = approved;
    //}
    //
    //}
}
