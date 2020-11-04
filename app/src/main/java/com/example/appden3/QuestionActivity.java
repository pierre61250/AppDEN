package com.example.appden3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuestionActivity extends AppCompatActivity {
    private static ProfilUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
    }

    public static void setUser(ProfilUser user) {
        QuestionActivity.user = user;
    }

}