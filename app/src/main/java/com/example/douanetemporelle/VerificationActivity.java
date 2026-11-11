package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {

    private TextView tvNom, tvAge, tvTrajet, tvMotif, tvAlerte, tvMrz;
    private Button btnApprouver, btnRefuser;

    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  norbto lclass b interface activity_verification
        setContentView(R.layout.activity_verification);

        // njibo les information bl id mte3hom
        tvNom = findViewById(R.id.tv_nom_xx);
        tvAge = findViewById(R.id.tv_age_xx);
        tvTrajet = findViewById(R.id.tv_trajet_xx);
        tvMotif = findViewById(R.id.tv_motif_xx);
        tvAlerte = findViewById(R.id.tv_alerte_xx);
        tvMrz = findViewById(R.id.tv_mrz_xx);
        btnApprouver = findViewById(R.id.btn_approuver_xx);
        btnRefuser = findViewById(R.id.btn_refuser_xx);

        // nst9blo les donnees
        Intent recu = getIntent();
        nom = recu.getStringExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_NOM));
        int naissance = recu.getIntExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_NAISSANCE), 0);
        int destination = recu.getIntExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_DESTINATION), 0);
        String motif = recu.getStringExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_MOTIF));

        // n7sbo lfr9 bin la3wem
        int difference = destination - naissance;

        // n7oto les informations fl passport
        tvNom.setText(nom);
        tvAge.setText(difference + " ans");
        tvTrajet.setText(naissance + "  →  " + destination);
        tvMotif.setText(motif);

        String nomMrz = nom.toUpperCase().replace(" ", "<");
        tvMrz.setText("P<TMP" + nomMrz + "<<" + naissance + "<" + destination);

        // ken 7atina modification de passé lezm il defference mtkonch premier
        boolean risque = motif != null
                && motif.equals(getString(R.string.motif_modification))
                && estPremier(difference);

        if (risque) {
            btnApprouver.setEnabled(false);
            tvAlerte.setText("⚠ Risque de paradoxe détecté !");
            tvAlerte.setVisibility(View.VISIBLE);
        }


        btnApprouver.setOnClickListener(v -> ouvrirVerdict(true));
        btnRefuser.setOnClickListener(v -> ouvrirVerdict(false));
    }

    // nb3tho chnawa i5tar w ism voyageur
    private void ouvrirVerdict(boolean approuve) {
        Intent intent = new Intent(VerificationActivity.this, ResultActivity.class);
        intent.putExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_VERDICT), approuve);
        intent.putExtra(Cles.construireCle(Cles.MATRICULE, Cles.SUFFIXE_NOM), nom);
        startActivity(intent);
    }

    // nthabto nombre premier ou non
    private boolean estPremier(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}