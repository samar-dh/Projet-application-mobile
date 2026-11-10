package com.example.douanetemporelle;

public class Cles {

    // رقم البطاقة: آخر 4 أرقام من بطاقة الطالب
    public static final String MATRICULE = "1234";

    // دالة ثابتة تبني مفتاح الـ putExtra انطلاقا من الرقم
    public static String construireCle(String matricule, String suffixe) {
        return matricule + "_" + suffixe;
    }

    // أسماء المفاتيح بدون الرقم
    public static final String SUFFIXE_NOM = "NOM_VOYAGEUR";
    public static final String SUFFIXE_NAISSANCE = "ANNEE_NAISSANCE";
    public static final String SUFFIXE_DESTINATION = "ANNEE_DESTINATION";
    public static final String SUFFIXE_MOTIF = "MOTIF";
    public static final String SUFFIXE_VERDICT = "VERDICT";
}