package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // norbto lclass b activity_result
        setContentView(R.layout.activity_result);

        // njibo les donnees li 7achetna bihom
        LinearLayout racine = findViewById(R.id.ll_racine_xx);
        TextView tvIcone = findViewById(R.id.tv_icone_xx);
        TextView tvMessage = findViewById(R.id.tv_message_xx);
        Button btnNouveau = findViewById(R.id.btn_nouveau_xx);

        // njibo chnawa e5tar w ism voyageur
        Intent recu = getIntent();
        boolean approuve = recu.getBooleanExtra(
                Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_VERDICT), false);
        String nom = recu.getStringExtra(
                Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_NOM));

        // nthabto w n7otto fond rouge ou vert
        if (approuve) {
            racine.setBackgroundColor(ContextCompat.getColor(this, R.color.vert_approuve));
            tvIcone.setText("✔");
            tvMessage.setText("Bon voyage " + nom + " !");
        } else {
            racine.setBackgroundColor(ContextCompat.getColor(this, R.color.rouge_refuse));
            tvIcone.setText("✖");
            tvMessage.setText(nom + " est en état d'arrestation temporelle");
        }

        // nrj3o l mainactivity
        btnNouveau.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }
}