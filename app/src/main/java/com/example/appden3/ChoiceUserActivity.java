package com.example.appden3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChoiceUserActivity extends AppCompatActivity {
    private Button newUserButton;
    private Button validerButton;

    private static ArrayList<ProfilUser> utilisateurs;

    private ProfilUser utilisateurSelectionner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_user);

        if (utilisateurs == null)
            utilisateurs = new ArrayList<>();

        utilisateurSelectionner = null;

        newUserButton = (Button) findViewById(R.id.new_user_button);
        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewUserActivity();
            }
        });

        validerButton = (Button) findViewById(R.id.buttonValider);
        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validerLeChoixDuser();
            }
        });
    }

    private void openNewUserActivity() {
        Intent intent = new Intent(this, NewUserActivity.class);
        this.startActivity(intent);
    }

    private void validerLeChoixDuser() {
            if (utilisateurSelectionner != null) {
            } else
                Toast.makeText(this, R.string.error_user_not_selected, Toast.LENGTH_SHORT).show();
    }

    public static void ajoutUtilisateur(ProfilUser new_user) {
        utilisateurs.add(new_user);
    }

}
