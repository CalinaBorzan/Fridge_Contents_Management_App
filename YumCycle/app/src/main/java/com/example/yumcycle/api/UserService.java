package com.example.yumcycle.api;

import com.example.yumcycle.models.LoginRequest;
import com.example.yumcycle.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("/api/users/register")
    Call<String> registerUser(@Body User user);

    @POST("/api/users/login")
    Call<String> loginUser(@Body LoginRequest loginRequest);
}
