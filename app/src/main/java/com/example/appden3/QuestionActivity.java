package com.example.appden3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.material.textfield.TextInputEditText;

public class QuestionActivity extends AppCompatActivity {
    private static ProfilUser user;
    private TextInputEditText inputTaux;
    private float tauxAlcool;
    private Switch recidiveUser;
    private boolean recidive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        inputTaux = (TextInputEditText) findViewById(R.id.inputTaux);

        recidiveUser = (Switch) findViewById(R.id.switch_recidive);

        Button buttonValider = (Button) findViewById(R.id.button_valider);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recupDonnées();
            }
        });
    }

    public void recupDonnées(){
        String recupTauxText = inputTaux.getText().toString().trim();
        if (recupTauxText != null && !recupTauxText.trim().equals(""))
            tauxAlcool = Integer.parseInt(recupTauxText);
        else
            Log.e("Erreur", "Erreur taux alcool");

        recidive = recidiveUser.isChecked();

        Intent intent = new Intent(this, ChoiceUserActivity.class);
        this.startActivity(intent);
    }

    public static void setUser(ProfilUser user) {
        QuestionActivity.user = user;
    }

}