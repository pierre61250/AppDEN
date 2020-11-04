package com.example.appden3;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReponsesActivity extends AppCompatActivity {

    private float tauxAlcool;
    private boolean recidive;
    private String user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reponses);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) tauxAlcool = extras.getFloat("tauxAlcool");
        if(extras != null) recidive = extras.getBoolean("recidive");
        if(extras != null) user = extras.getString("user");
    }


}
