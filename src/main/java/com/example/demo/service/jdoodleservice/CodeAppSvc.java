package com.example.demo.service.jdoodleservice;

import com.example.demo.domain.composites.RequestCompilerJson;
import com.example.demo.domain.composites.ResponseCompilerJson;
import okhttp3.OkHttpClient;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

@Service
public class CodeAppSvc {

    private static final String BASE_URL = "https://api.jdoodle.com/v1/";

    public ResponseCompilerJson execute(RequestCompilerJson request) {
        ResponseCompilerJson responseCompilerJson = new ResponseCompilerJson();
        APIService apiService = getApiService();
        Call<String> response = apiService.execute(request);

        try {
            Response<String> responseMsg =  response.execute();
            String str = responseMsg.body();
            JSONObject responseJson = new JSONObject(str);
            responseCompilerJson.setOutput(responseJson.get("output").toString());
            responseCompilerJson.setStatusCode(responseJson.get("statusCode").toString());
            responseCompilerJson.setMemory(Long.parseLong(responseJson.get("memory").toString()));
            responseCompilerJson.setCpuTime(Double.parseDouble(responseJson.get("cpuTime").toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseCompilerJson;
    }

    private APIService getApiService() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        return retrofit.create(APIService.class);
    }
}
