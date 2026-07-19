package com.example.bankapp;

import com.example.bankapp.models.TransferRequest;
import com.example.bankapp.models.TransferResponse;
import com.example.bankapp.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("api/user/{account}")
    Call<UserResponse> getUser(@Path("account") String account);

    @POST("api/transfer")
    Call<TransferResponse> transferMoney(@Body TransferRequest request);

}