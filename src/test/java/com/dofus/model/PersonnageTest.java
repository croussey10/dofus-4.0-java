// PersonnageTest.java
package com.dofus.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {

    @Test
    void devrait_initialiser_personnage_avec_valeurs_correctes() {
        // Ordre des paramètres corrigé : nom, pvMax, PA, classe
        Personnage perso = new Personnage("Tristepin", 100, 6, ClassePersonnage.IOP);

        assertEquals("Tristepin", perso.getNom());
        assertEquals(ClassePersonnage.IOP, perso.getClasse());
        assertEquals(100, perso.getPvActuels());
        assertEquals(6, perso.getPointsAction());
    }

    @Test
    void ne_devrait_pas_avoir_pv_negatifs_apres_degats() {
        Personnage perso = new Personnage("Goultard", 100, 6, ClassePersonnage.IOP);
        perso.recevoirDegats(150);
        assertEquals(0, perso.getPvActuels(), "Les PV ne doivent jamais descendre en dessous de 0");
    }

    @Test
    void ne_devrait_pas_depasser_pv_max_apres_soin() {
        Personnage perso = new Personnage("Eni", 100, 6, ClassePersonnage.ENIRIPSA);
        perso.recevoirDegats(20);
        perso.recevoirSoins(50);
        assertEquals(100, perso.getPvActuels(), "Les PV ne doivent pas dépasser le maximum");
    }

    @Test
    void devrait_consommer_pa_uniquement_si_suffisants() {
        Personnage perso = new Personnage("Cra", 100, 6, ClassePersonnage.CRA);
        assertTrue(perso.consommerPA(4));
        assertEquals(2, perso.getPointsAction());

        assertFalse(perso.consommerPA(4));
        assertEquals(2, perso.getPointsAction(), "Les PA ne doivent pas être déduits si l'action échoue");
    }
}