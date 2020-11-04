package com.example.appden3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class QuestionActivity extends AppCompatActivity {
    private static ProfilUser user;
    private EditText inputTaux;
    private double tauxAlcool;
    private Switch recidiveUser;
    private boolean recidive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        inputTaux = (EditText) findViewById(R.id.inputTaux);

        recidiveUser = (Switch) findViewById(R.id.switch_recidive);

        Button buttonValider = (Button) findViewById(R.id.button_valider);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recupDonnees();
            }
        });
    }

    public void recupDonnees() {
        boolean argumentsValid = true;
        String recupTauxText = inputTaux.getText().toString().trim();
        if (!recupTauxText.trim().equals(""))
            tauxAlcool = Double.parseDouble(recupTauxText);
        else {
            argumentsValid = false;
            inputTaux.setError(getResources().getString(R.string.error_input_null));
        }

        recidive = recidiveUser.isChecked();

        if (argumentsValid) {
            changeActivity();
        }
    }

    private void changeActivity() {
        Intent intent = new Intent(this, ReponsesActivity.class);
        if (intent.getExtras() != null)
            intent.getExtras().clear();

        intent.putExtra("tauxAlcool", tauxAlcool);
        intent.putExtra("recidive", recidive);
        intent.putExtra("userProbatoire", user.isProbatoire());
        intent.putExtra("userPoints", user.getNb_points());
        this.startActivity(intent);
    }

    public static void setUser(ProfilUser user) {
        QuestionActivity.user = user;
    }

}
