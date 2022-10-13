package com.a_23_59.mvvmwithretrofit;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("experts/student")
    Single<Response> getArticles();

}
