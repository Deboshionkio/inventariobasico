package com.example.inventariomanager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InventarioManager extends AppCompatActivity {

    private EditText editTextLogin;
    private EditText editTextSenha;
    private Button buttonLogar;
    private Button buttonCriarConta;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario_manager);

        editTextLogin = findViewById(R.id.editTextLogin);
        editTextSenha = findViewById(R.id.editTextSenha);
        buttonLogar = findViewById(R.id.buttonLogar);
        buttonCriarConta = findViewById(R.id.buttonSalvar);

        // Criar ou abrir o banco de dados
        SQLiteOpenHelper dbHelper = new SQLiteOpenHelper(this, "nome_do_banco", null, 1) {
            @Override
            public void onCreate(SQLiteDatabase db) {
                // Criar tabela para armazenar os dados do usuário
                String createUserTableQuery = "CREATE TABLE IF NOT EXISTS usuario (email TEXT PRIMARY KEY, senha TEXT)";
                db.execSQL(createUserTableQuery);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                // Lógica para atualização do banco de dados, se necessário
            }
        };
        database = dbHelper.getWritableDatabase();

        buttonLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString();
                String senha = editTextSenha.getText().toString();

                if (validarLogin(login, senha)) {
                    // Redirecionar para a activity LogouSucesso
                    Intent intent = new Intent(InventarioManager.this, LogouSucesso.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(InventarioManager.this, "Login ou senha inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString();
                String senha = editTextSenha.getText().toString();

                if (criarConta(login, senha)) {
                    Toast.makeText(InventarioManager.this, "Conta criada com sucesso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(InventarioManager.this, "Não foi possível criar a conta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validarLogin(String login, String senha) {
        String query = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        String[] selectionArgs = {login, senha};

        Cursor cursor = database.rawQuery(query, selectionArgs);
        boolean loginValido = cursor.getCount() > 0;
        cursor.close();

        return loginValido;
    }

    private boolean criarConta(String login, String senha) {
        ContentValues values = new ContentValues();
        values.put("email", login);
        values.put("senha", senha);

        long resultado = database.insert("usuario", null, values);
        return resultado != -1;
    }
}
