package com.gyamfimartins.codeexercise.network;

import com.gyamfimartins.codeexercise.model.Guide;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GuideApi {
    @GET("upcomingGuides/")
    Call<Guide> getGuides();
}
