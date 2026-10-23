package com.dofus.model;

public abstract class Combattant {

    private final String nom;
    private int pvMax;
    private int pvActuel;
    private int PA;

    public Combattant(String nom, int pvMax, int PA) {
        this.nom = nom;
        this.pvMax = pvMax;
        this.pvActuel = pvMax;
        this.PA = PA;
    }

    public void recevoirDegats(int degats) {
       this.pvActuel = Math.max(0, this.pvActuel - degats);
    }

    public void recevoirSoins(int soins) {
        this.pvActuel = Math.min(this.pvActuel + soins, this.pvMax);
    }

    public boolean consommerPA(int PA) {
        if(this.PA - PA < 0) return false;
        this.PA -= PA;
        return true;
    }

    public String getNom() {
        return this.nom;
    }

    public int getPvActuels() {
        return this.pvActuel;
    }

    public int getPointsAction() {
        return this.PA;
    }
}
