// MonstreTest.java
package com.dofus.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MonstreTest {

    @Test
    void un_monstre_doit_pouvoir_recevoir_des_degats() {
        // Utilisation de l'Enum FamilleMonstre et ordre corrigé
        Monstre bouftou = new Monstre("Chef de Guerre", 150, 5, FamilleMonstre.BOUFTOU);

        bouftou.recevoirDegats(50);

        assertEquals(100, bouftou.getPvActuels());
        assertEquals(FamilleMonstre.BOUFTOU, bouftou.getFamille());
    }

    @Test
    void un_personnage_et_un_monstre_sont_des_combattants() {
        Personnage perso = new Personnage("Tristepin", 100, 6, ClassePersonnage.IOP);
        // Ajoute TOFU dans ton enum FamilleMonstre pour que ça compile
        Monstre monstre = new Monstre("Tofu Maladif", 20, 3, FamilleMonstre.TOFU);

        List<Combattant> arene = List.of(perso, monstre);

        assertEquals(2, arene.size());

        arene.get(0).recevoirDegats(10);
        assertEquals(90, perso.getPvActuels());
    }
}