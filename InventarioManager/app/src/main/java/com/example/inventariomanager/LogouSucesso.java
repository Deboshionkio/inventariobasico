package com.example.inventariomanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LogouSucesso extends AppCompatActivity {

    private Button buttonProsseguir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logou_sucesso);

        buttonProsseguir = findViewById(R.id.buttonProsseguir);

        buttonProsseguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar para a activity SelecaoItem
                Intent intent = new Intent(LogouSucesso.this, SelecaoItem.class);
                startActivity(intent);
            }
        });
    }
}
