package com.example.proyectoahorromovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText user, passwd;
    Button login, registry;
    CheckBox save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.txtUsuario);
        passwd = findViewById(R.id.txtContrasena);
        login = findViewById(R.id.btnIngresar);
        registry = findViewById(R.id.btnRegistrar);
        save = findViewById(R.id.chGuardar);
    }

    public void mandarActivityRegistro(View view) {
        Intent cargarRegiistro = new Intent(LoginActivity.this, RegistroActivity.class);
        startActivity(cargarRegiistro);
    }
}