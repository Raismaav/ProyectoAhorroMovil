package com.example.proyectoahorromovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyectoahorromovil.R;

public class AhorrosActivity extends AppCompatActivity {
    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorros);
        usuario = getIntent().getStringExtra("usuario");
    }

    public void regresar(View view) {
        Intent loadMain = new Intent(this, MainActivity.class);
        loadMain.putExtra("usuario", usuario);
        startActivity(loadMain);
    }
}