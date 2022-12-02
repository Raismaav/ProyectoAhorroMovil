package com.example.proyectoahorromovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class CargaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);
        Intent cargarLogin = new Intent(CargaActivity.this, LoginActivity.class);
        startActivity(cargarLogin);
    }
}