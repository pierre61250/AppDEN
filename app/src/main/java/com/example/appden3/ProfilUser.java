package com.example.appden3;

public class ProfilUser {
    private String nomUser;
    private boolean probatoire;
    private int nb_points;

    public ProfilUser(String nomUser, boolean probatoire, int nb_points) {
        this.nomUser = nomUser;
        this.probatoire = probatoire;
        this.nb_points = nb_points;
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
