package com.example.teamenvironmentkenya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.teamenvironmentkenya.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AppCompatActivity {
    private ActivitySettingsBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

    }


}