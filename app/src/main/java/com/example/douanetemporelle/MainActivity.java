package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // 1) njibo les donnees de l'interface
    private EditText etNom, etNaissance, etDestination;
    private RadioGroup rgMotif;
    private Button btnInspecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2) rbatna lclass bl interface
        setContentView(R.layout.activity_main);

        // 3) ربط المتغيرات بالعناصر عن طريق الـ id
        etNom = findViewById(R.id.et_XX_nom);
        etNaissance = findViewById(R.id.et_XX_naissance);
        etDestination = findViewById(R.id.et_XX_destination);
        rgMotif = findViewById(R.id.rg_XX_motif);
        btnInspecter = findViewById(R.id.btn_XX_inspecter);

        // 4) عند الضغط على الزر
        btnInspecter.setOnClickListener(v -> inspecter());
    }

    private void inspecter() {
        // 5) قراءة القيم المدخلة
        String nom = etNom.getText().toString().trim();
        String naissance = etNaissance.getText().toString().trim();
        String destination = etDestination.getText().toString().trim();
        int idMotif = rgMotif.getCheckedRadioButtonId();

        // 6) التحقق من أن كل الحقول مملوءة
        if (nom.isEmpty() || naissance.isEmpty() || destination.isEmpty() || idMotif == -1) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        // 7) جلب نص الاختيار (الدافع)
        RadioButton rbChoisi = findViewById(idMotif);
        String motif = rbChoisi.getText().toString();

        // 8) إنشاء Intent صريح نحو النشاط الثاني
        Intent intent = new Intent(MainActivity.this, VerificationActivity.class);

        // 9) إرسال البيانات بمفاتيح مبنية بالدالة الثابتة
        intent.putExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_NOM), nom);
        intent.putExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_NAISSANCE), Integer.parseInt(naissance));
        intent.putExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_DESTINATION), Integer.parseInt(destination));
        intent.putExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_MOTIF), motif);

        // 10) تشغيل النشاط الثاني
        startActivity(intent);
    }
}