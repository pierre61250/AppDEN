package com.example.appden3;

public class ProfilUser {
    private int nb_points;
    private boolean probatoire;

    public ProfilUser(int nb_points, boolean probatoire) {
        this.nb_points = nb_points;
        this.probatoire = probatoire;
    }

    public int getNb_points() {
        return nb_points;
    }

    public void setNb_points(int nb_points) {
        this.nb_points = nb_points;
    }

    public boolean isProbatoire() {
        return probatoire;
    }

    public void setProbatoire(boolean probatoire) {
        this.probatoire = probatoire;
    }

}
