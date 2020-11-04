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
    private String repPeine = "", repRecidive ="", repPoints ="";

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
        if (tauxAlcool >= 0.8){
            repPeine = this.getResources().getString(R.string.sanction_niv2);
            if (recidive){
                repRecidive = this.getResources().getString(R.string.sanction_niv2_recidiviste);
            }
            else {
                repRecidive = this.getResources().getString(R.string.sanction_niv2_non_recidiviste);
            }
        }
        else if((tauxAlcool >= 0.5 && !probatoire) || (tauxAlcool >= 0.25 && probatoire)){
            repPeine = this.getResources().getString(R.string.sanction_niv1);
        }
        points = points - 6;
        if (points <= 0){
            repPoints = this.getResources().getString(R.string.annul);
        }
        else {
            repPoints = "Il vous reste " + points + " point(s) sur votre permis";
        }

        reponse.setText(repPeine + repRecidive + repPoints);
    }


}
