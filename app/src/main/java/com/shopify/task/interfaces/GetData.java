package com.shopify.task.interfaces;


import com.shopify.task.model.ResponseData;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface GetData {



    @GET("/admin/api/2020-01/products.json")
    Call<ResponseData> provideProducts(@Header("Authorization") String token);
}
