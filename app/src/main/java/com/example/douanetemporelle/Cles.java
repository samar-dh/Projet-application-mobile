package com.example.douanetemporelle;

public class Cles {

    // e5r 4 ar9am mn carte etudiant
    public static final String MATRICULE = "1234";

    public static String construireCle(String matricule, String suffixe) {
        return matricule + "_" + suffixe;
    }

    public static final String SUFFIXE_NOM = "NOM_VOYAGEUR";
    public static final String SUFFIXE_NAISSANCE = "ANNEE_NAISSANCE";
    public static final String SUFFIXE_DESTINATION = "ANNEE_DESTINATION";
    public static final String SUFFIXE_MOTIF = "MOTIF";
    public static final String SUFFIXE_VERDICT = "VERDICT";
}