package com.example.appden3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChoiceUserActivity extends AppCompatActivity {
    private Button newUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_user);

        newUserButton = (Button) findViewById(R.id.new_user_button);
        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewUserActivity();
            }
        });
    }

    private void openNewUserActivity() {
        this.startActivity(new Intent(this, NewUserActivity.class));
    }
}
