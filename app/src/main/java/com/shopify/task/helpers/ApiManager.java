package com.shopify.task.helpers;


import com.shopify.task.interfaces.GetData;
import com.shopify.task.model.ResponseData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static GetData service;
    private static ApiManager apiManager;
    private static String BASE_URL = "https://edbe82e912a421359d814329431aaa8c:88484ec446e39fd6452cb7fc6316b614@shopappandroid.myshopify.com/";
    private static String TOKEN = "Basic ZWRiZTgyZTkxMmE0MjEzNTlkODE0MzI5NDMxYWFhOGM6ODg0ODRlYzQ0NmUzOWZkNjQ1MmNiN2ZjNjMxNmI2MTQ=";

    private ApiManager() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(GetData.class);
    }

    public static ApiManager getInstance() {
        if (apiManager == null) {
            apiManager = new ApiManager();
        }
        return apiManager;
    }

    public void provideProducts(Callback<ResponseData> callback) {
        Call<ResponseData> call = service.provideProducts(TOKEN);
        call.enqueue(callback);
    }

}
