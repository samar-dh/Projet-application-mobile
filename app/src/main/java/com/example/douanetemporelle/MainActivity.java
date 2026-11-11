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

    // njibo les donnees de l'interface
    private EditText etNom, etNaissance, etDestination;
    private RadioGroup rgMotif;
    private Button btnInspecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // rbatna lclass bl interface
        setContentView(R.layout.activity_main);

        //  rbatnanehom bl les id
        etNom = findViewById(R.id.et_XX_nom);
        etNaissance = findViewById(R.id.et_XX_naissance);
        etDestination = findViewById(R.id.et_XX_destination);
        rgMotif = findViewById(R.id.rg_XX_motif);
        btnInspecter = findViewById(R.id.btn_XX_inspecter);

        btnInspecter.setOnClickListener(v -> inspecter());
    }

    private void inspecter() {
        String nom = etNom.getText().toString().trim();
        String naissance = etNaissance.getText().toString().trim();
        String destination = etDestination.getText().toString().trim();
        int idMotif = rgMotif.getCheckedRadioButtonId();

        //  nt2kdo mathama 7ta champ vide
        if (nom.isEmpty() || naissance.isEmpty() || destination.isEmpty() || idMotif == -1) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton rbChoisi = findViewById(idMotif);
        String motif = rbChoisi.getText().toString();

        // n3mlo intent
        Intent intent = new Intent(MainActivity.this, VerificationActivity.class);

        // nb3tho les informations
        intent.putExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_NOM), nom);
        intent.putExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_NAISSANCE), Integer.parseInt(naissance));
        intent.putExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_DESTINATION), Integer.parseInt(destination));
        intent.putExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_MOTIF), motif);

        // n7lo l'activite li b3do
        startActivity(intent);
    }
}