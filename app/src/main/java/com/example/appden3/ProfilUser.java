package com.example.appden3;

import android.util.Log;

public class ProfilUser {
    private String nomUser;
    private boolean probatoire;
    private int nb_points;

    public ProfilUser(String nomUser, boolean probatoire, int nb_points) {
        this.nomUser = nomUser;
        this.probatoire = probatoire;
        this.nb_points = nb_points;
    }

    public static ProfilUser createNewUser(String nomUser, boolean probatoire, int nb_points) {
        ProfilUser new_profile = new ProfilUser(nomUser, probatoire, nb_points);
        Log.i("application profil", new_profile.toString());
        return new_profile;
    }

    @Override
    public String toString() {
        return nomUser + " - " + ((probatoire)?"permis probatoire - ":"") + nb_points + " points";
    }

    public String getNomUser() {
        return nomUser;
    }

    public boolean isProbatoire() {
        return probatoire;
    }

    public int getNb_points() {
        return nb_points;
    }

}
