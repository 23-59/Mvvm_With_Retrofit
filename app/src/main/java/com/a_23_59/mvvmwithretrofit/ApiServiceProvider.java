package com.a_23_59.mvvmwithretrofit;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceProvider {

    private static ApiService apiService;

    public static ApiService getApiService(){

        if (apiService==null){

            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("http://api.mediastack.com/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();

            apiService=retrofit.create(ApiService.class);
        }

        return apiService;

    }
}
