package com.gyamfimartins.codeexercise.repository;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gyamfimartins.codeexercise.model.Data;
import com.gyamfimartins.codeexercise.model.Guide;
import com.gyamfimartins.codeexercise.network.GuideApi;
import com.gyamfimartins.codeexercise.network.RetrofitRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GuideRepository  {

    public GuideRepository() {

    }

    public LiveData<List<Data>> getGuides() {
        final MutableLiveData<List<Data>> data = new MutableLiveData<>();

        GuideApi guideApi = RetrofitRequest.getRetrofitInstance().create(GuideApi.class);
        Call<Guide> call = guideApi.getGuides();

        call.enqueue(new Callback<Guide>() {
            @Override
            public void onResponse(Call<Guide> call, Response<Guide> response) {

                if (!response.isSuccessful()) {
                   // String code = "code: " + response.code();
                    data.setValue(null);
                    return;
                }

                Guide guide = response.body();
                List<Data> guideList = guide.getData();
                data.setValue(guideList);
            }

            @Override
            public void onFailure(Call<Guide> call, Throwable t) {
                data.setValue(null);
            }
        });


        return data;
    }
}
