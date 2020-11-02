package com.example.appden3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class NewUserActivity extends AppCompatActivity {
    private static ChoiceUserActivity activity;

    private TextInputEditText nomUser;
    private Switch probatoireUser;
    private EditText pointPermisUser;
    private Button saveParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newuser_activity);

        saveParam = (Button) findViewById(R.id.button_save);
        saveParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveParameters();
            }
        });

        nomUser = (TextInputEditText) findViewById(R.id.container_nom_user);

        probatoireUser = (Switch) findViewById(R.id.probatoire);

        pointPermisUser = (EditText) findViewById(R.id.pointSurPermis);
    }

    public static void setActivity(ChoiceUserActivity activity) {
        NewUserActivity.activity = activity;
    }

    private void saveParameters() {
        // initialisation
        String nom = "";
        boolean probatoire = false;
        int nombre_point = 0;

        // cet variable verifie si il n'y a pas d'erreur
        boolean argumentsValid = true;
        String error_valeur_non_saisie = getResources().getString(R.string.error_input_null);


        // attribution des valeurs
        if (nomUser != null && !nomUser.getText().toString().equals(""))
            nom = nomUser.getText().toString().trim();
        else
            nomUser.setError(error_valeur_non_saisie);

        probatoire = probatoireUser.isChecked();

        String pointText = pointPermisUser.getText().toString().trim();
        if (pointPermisUser != null && !pointText.trim().equals(""))
            nombre_point = Integer.parseInt(pointText);
        else
            pointPermisUser.setError(error_valeur_non_saisie);

        // on verifie qu'il n'y a pas d'erreur
        argumentsValid = (nomUser != null && pointPermisUser != null && !pointText.equals(""));
        // on verifie qu'il n'y a pas d'erreur dans la saisie des valeurs par l'utilisateur
        argumentsValid = argumentsValid && gestionErreur(nom, nombre_point, error_valeur_non_saisie);


        // si il n'y a pas d'erreur
        if (argumentsValid) {
            // on ajoute un nouvel utilisateur
            ProfilUser new_user = ProfilUser.createNewUser(nom, probatoire, nombre_point);
            activity.ajoutUtilisateur(new_user);
            (new UserXML(this)).saveUser(new_user);

            // puis on ferme la page
            this.finish();
        }
    }

    private boolean gestionErreur(String nom, int nombre_point, String error_valeur_non_saisie) {
        // si il n'y a pas un nombre normal de points sur le permis
        if (nombre_point < 0 || nombre_point > 12) {
            pointPermisUser.setError(getResources().getString(R.string.error_point_user));
            return false;
        }

        return true;
    }

}
