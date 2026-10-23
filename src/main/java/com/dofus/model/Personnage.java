package com.dofus.model;

public class Personnage extends Combattant {
    private final ClassePersonnage classePersonnage;

    public Personnage(String nom, int pvMax, int PA, ClassePersonnage classePersonnage) {
        super(nom, pvMax, PA);
        this.classePersonnage = classePersonnage;
    }

    public ClassePersonnage getClasse() {
        return this.classePersonnage;
    }
}
