package com.example.appden3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChoiceUserActivity extends AppCompatActivity {
    private RadioGroup radioGroup;

    private ArrayList<ProfilUser> utilisateurs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_user);

        UserXML extractor = new UserXML(this);

        if (utilisateurs == null)
            utilisateurs = extractor.getProfilsUsers();

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupe);
        for (ProfilUser user : utilisateurs) {
            ajoutNewChoiceToRadioGroup(user);
        }

        Button newUserButton = (Button) findViewById(R.id.new_user_button);
        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewUserActivity();
            }
        });

        Button validerButton = (Button) findViewById(R.id.buttonValider);
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
        NewUserActivity.setActivity(this);
    }

    public void ajoutUtilisateur(ProfilUser new_user) {
        utilisateurs.add(new_user);
        ajoutNewChoiceToRadioGroup(new_user);
    }

    private void ajoutNewChoiceToRadioGroup(ProfilUser user) {
        RadioButton userButton = new RadioButton(this);
        userButton.setText(user.getInfosUser());
        radioGroup.addView(userButton);
    }

    public boolean hasUserThisName(String name) {
        for (ProfilUser user : utilisateurs)
            if (user.getNomUser().equals(name))
                return true;

        return false;
    }

    private void validerLeChoixDuser() {
        // verifie qu'un utilisateur ai bien ete selectionee
        if (radioGroup.getCheckedRadioButtonId() != -1) {
            Intent intent = new Intent(this, QuestionActivity.class);
            this.startActivity(intent);

            ProfilUser currentChoice = utilisateurs.get(radioGroup.getCheckedRadioButtonId());
            QuestionActivity.setUser(currentChoice);
        } else
            Toast.makeText(this, R.string.error_user_not_selected, Toast.LENGTH_SHORT).show();
    }

}
