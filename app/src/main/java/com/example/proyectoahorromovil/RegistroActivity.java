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
        name = findViewById(R.id.txtNombre);
        lastname = findViewById(R.id.txtApellido);
        age = findViewById(R.id.txtEdad);
        username = findViewById(R.id.txtNombreUsuario);
        passwdUser = findViewById(R.id.txtConstrasenaUusario);
        sex = findViewById(R.id.spSexo);
        registryUser = findViewById(R.id.btnRegistrarUsuario);
        back = findViewById(R.id.btnRegresarLogin);
    }

    public void regresarLogin(View view) {
        Intent cargarLogin = new Intent(RegistroActivity.this, LoginActivity.class);
        startActivity(cargarLogin);
    }
}