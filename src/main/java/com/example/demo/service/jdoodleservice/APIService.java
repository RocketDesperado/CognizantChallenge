package com.example.demo.service.jdoodleservice;

import com.example.demo.domain.composites.RequestCompilerJson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @POST("execute")
    @Headers("Content-Type: application/json")
    Call<String> execute(@Body RequestCompilerJson requestCompilerJson);

}
