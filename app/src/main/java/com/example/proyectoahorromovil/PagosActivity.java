package com.example.proyectoahorromovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectoahorromovil.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PagosActivity extends AppCompatActivity {

    EditText contenido;
    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos);
        usuario = getIntent().getStringExtra("usuario");
        contenido = findViewById(R.id.txtMostrarPagos);
        String files[] = fileList();
        if(archivoExiste(files, usuario + "_payments.txt")) {
            try {
                InputStreamReader contentFile = new InputStreamReader(openFileInput(usuario + "_payments.txt"));
                BufferedReader br = new BufferedReader(contentFile);
                String firstLine = br.readLine();
                String allFile = "";
                while (firstLine != null) {
                    allFile += firstLine + "\n";
                    firstLine = br.readLine();
                }
                br.close();
                contentFile.close();
                contenido.setText(allFile);
            } catch (IOException ex) {
                Toast.makeText(this, "No se pudo leer el archivo.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "El archivo no existe.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean archivoExiste(String files[], String nameFile) {
        for(int i = 0; i < files.length; i++)
            if(nameFile.equals(files[i]))
                return true;
        return false;
    }

    public void regresar(View view) {
        Intent loadMain = new Intent(this, MainActivity.class);
        loadMain.putExtra("usuario", usuario);
        startActivity(loadMain);
    }
}