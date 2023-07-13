package com.example.inventariomanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SelecaoItem extends AppCompatActivity {

    private Button buttonArmas;
    private Button buttonArmaduras;
    private Button buttonPocoes;
    private Button buttonDiversos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_item);

        buttonArmas = findViewById(R.id.buttonArmas);
        buttonArmaduras = findViewById(R.id.buttonArmaduras);
        buttonPocoes = findViewById(R.id.buttonPocoes);
        buttonDiversos = findViewById(R.id.buttonDiversos);

        buttonArmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a activity de Armas
                Intent intent = new Intent(SelecaoItem.this, ArmasActivity.class);
                startActivity(intent);
            }
        });

        buttonArmaduras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a activity de Armaduras
                Intent intent = new Intent(SelecaoItem.this, ArmadurasActivity.class);
                startActivity(intent);
            }
        });

        buttonPocoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a activity de Poções
                Intent intent = new Intent(SelecaoItem.this, PocoesActivity.class);
                startActivity(intent);
            }
        });

        buttonDiversos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a activity de Diversos
                Intent intent = new Intent(SelecaoItem.this, DiversosActivity.class);
                startActivity(intent);
            }
        });
    }
}
