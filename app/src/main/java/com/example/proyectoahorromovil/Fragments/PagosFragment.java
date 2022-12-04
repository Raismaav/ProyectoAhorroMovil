package com.example.proyectoahorromovil.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.proyectoahorromovil.MainActivity;
import com.example.proyectoahorromovil.Modelo.Inversion;
import com.example.proyectoahorromovil.Modelo.Pago;
import com.example.proyectoahorromovil.R;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class PagosFragment extends Fragment {
    private EditText claveRastreo, emisor, receptor, cuentaBeneficiaria, montoPago;
    private String usuario;

    public PagosFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuario = getActivity().getIntent().getStringExtra("usuario");
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inversiones, container, false);
        claveRastreo = view.findViewById(R.id.edt_clave_pago);
        emisor = view.findViewById(R.id.edt_emisor_pago);
        receptor = view.findViewById(R.id.edt_cuenta_pago);
        cuentaBeneficiaria = view.findViewById(R.id.edt_beneficiario_pago);
        montoPago = view.findViewById(R.id.edt_monto_pago);


        return inflater.inflate(R.layout.fragment_pagos, container, false);
    }
    public void RegistrarPagos(View view) {

        if (!claveRastreo.getText().toString().equals("") && !emisor.getText().toString().equals("") && !receptor.getText().toString().equals("") && !cuentaBeneficiaria.getText().toString().equals("")&& !montoPago.getText().toString().equals("") ) {
            try {
                OutputStreamWriter createFileInformationUser = new OutputStreamWriter(getActivity().openFileOutput("_payments.txt", Activity.MODE_PRIVATE));

                createFileInformationUser.write(claveRastreo.getText().toString() + "\n" + emisor.getText().toString() + "\n" + receptor.getText().toString() + "\n" + cuentaBeneficiaria.getText().toString() + "\n"+ montoPago.getText().toString() + "\n");
                createFileInformationUser.flush();
                createFileInformationUser.close();
                Toast.makeText(getActivity(), "Pago registrado correctamente", Toast.LENGTH_SHORT).show();
                Intent registroInversion = new Intent(getActivity(), MainActivity.class);
                startActivity(registroInversion);
            } catch (IOException e) {
                Toast.makeText(getActivity(), "No se pudieron guardar los datos", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private boolean archivoExiste(String files[], String nameFile) {
        for (int i = 0; i < files.length; i++)
            if (nameFile.equals(files[i]))
                return true;
        return false;
    }


    public void guardardatos(Pago pagos) {
        SharedPreferences preferences = getActivity().getSharedPreferences("pagos.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Clave rastreo", pagos.getClaveRastreo());
        editor.putString("Emisor", pagos.getEmisor());
        editor.putString("Receptorn", pagos.getReceptor());
        editor.putInt("Cuenta beneficiaria", pagos.getCuentaBeneficiaria());
        editor.putInt("Montopago", pagos.getMontoPago());
        editor.apply();
    }

    public void regresarPrincipal(View view) {
        Intent regresarMain = new Intent(getActivity(), MainActivity.class);
        startActivity(regresarMain);

    }

}
