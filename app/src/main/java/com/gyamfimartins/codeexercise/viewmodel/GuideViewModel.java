package com.gyamfimartins.codeexercise.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.gyamfimartins.codeexercise.model.Data;
import com.gyamfimartins.codeexercise.repository.GuideRepository;

import java.util.List;

public class GuideViewModel extends AndroidViewModel {
    private GuideRepository guideRepository;
    public GuideViewModel(@NonNull Application application) {
        super(application);
        guideRepository = new GuideRepository();
    }
    public LiveData<List<Data>> getAllGuides() {
        return guideRepository.getGuides();
    }
}
