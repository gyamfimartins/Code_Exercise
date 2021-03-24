package com.gyamfimartins.codeexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import com.gyamfimartins.codeexercise.adapter.GuideAdapter;
import com.gyamfimartins.codeexercise.model.Data;
import com.gyamfimartins.codeexercise.utils.SimpleDividerItemDecoration;
import com.gyamfimartins.codeexercise.viewmodel.GuideViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GuideViewModel guideViewModel;
    private RecyclerView rvGuides;
    private GuideAdapter guideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGuides = findViewById(R.id.rvGuides);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvGuides.setHasFixedSize(true);
        rvGuides.setLayoutManager(linearLayoutManager);
        rvGuides.addItemDecoration(new SimpleDividerItemDecoration(this));

        guideViewModel = new ViewModelProvider(this).get(GuideViewModel.class);
        guideAdapter = new GuideAdapter();
        getGuides();
    }

    private void getGuides(){
        guideViewModel.getAllGuides().observe(this, new Observer<List<Data>>() {
            @Override
            public void onChanged(List<Data> data) {
              guideAdapter.getguideList(data,getApplicationContext());
               rvGuides.setAdapter(guideAdapter);

            }
        });
    }
}