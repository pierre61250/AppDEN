package com.example.appden3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReponsesActivity extends AppCompatActivity {

    private Double tauxAlcool;
    private boolean recidive;
    private boolean probatoire;
    private int points;
    private TextView reponse;
    private Button recommencer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reponses);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null) tauxAlcool = extras.getDouble("tauxAlcool");
        if(extras != null) recidive = extras.getBoolean("recidive");
        if(extras != null) probatoire = extras.getBoolean("userProbatoire");
        if(extras != null) points = extras.getInt("userPoints");
        reponse = findViewById(R.id.text_resultat);
        recommencer = findViewById(R.id.button_recommencer);

        sanction(tauxAlcool,recidive,probatoire, points);
    }

    private void sanction(Double tauxAlcool, boolean recidive, boolean probatoire, int points) {
        if (points <= 6){

        }
    }


}
