package com.dofus.model;

public class Monstre extends Combattant {
    private final FamilleMonstre familleMonstre;

    public Monstre(String nom, int pvMax, int PA, FamilleMonstre familleMonstre) {
        super(nom, pvMax, PA);
        this.familleMonstre = familleMonstre;
    }

    public FamilleMonstre getFamille() {
        return this.familleMonstre;
    }
}


