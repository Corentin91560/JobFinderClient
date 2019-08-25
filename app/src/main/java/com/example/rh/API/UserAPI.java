package com.example.rh.API;

import com.example.rh.models.Loging;
import com.example.rh.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserAPI {
    @POST("signin/candidat")
    Call<List<User>> createUser(@Body Loging loging);
}
