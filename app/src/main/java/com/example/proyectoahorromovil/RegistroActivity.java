package com.example.proyectoahorromovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RegistroActivity extends AppCompatActivity {

    EditText name, lastname, age, username, passwdUser;
    Spinner sex;
    Button registryUser, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        name = findViewById(R.id.edt_nombre_registro);
        lastname = findViewById(R.id.edt_apellido_registro);
        age = findViewById(R.id.edt_edad_registro);
        username = findViewById(R.id.edt_usuario_registro);
        passwdUser = findViewById(R.id.edt_contrasenna_registro);
        sex = findViewById(R.id.spn_sexo_registro);
        registryUser = findViewById(R.id.btn_registro_usuario);
        back = findViewById(R.id.btn_regresar_login);
    }

    public void regresarLogin(View view) {
        Intent cargarLogin = new Intent(RegistroActivity.this, LoginActivity.class);
        startActivity(cargarLogin);
    }
}