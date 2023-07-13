package com.example.inventariomanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ErroVoltarLogin extends AppCompatActivity {

    private Button buttonRetrErroLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erro_voltar_login);

        buttonRetrErroLogin = findViewById(R.id.buttonRetrErroLogin);

        buttonRetrErroLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirecionar de volta para a activity InventarioManager
                Intent intent = new Intent(ErroVoltarLogin.this, InventarioManager.class);
                startActivity(intent);
            }
        });
    }
}
