package com.example.proyectoahorromovil.Fragments;


import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.proyectoahorromovil.MainActivity;
import com.example.proyectoahorromovil.Modelo.Ahorro;
import com.example.proyectoahorromovil.Modelo.Gasto;
import com.example.proyectoahorromovil.R;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class GastosFragment extends Fragment {
    EditText nomGasto,montoGasto, lugarGasto;
    RadioButton fijoGasto,variadoGasto, inesperadoGasto;
    public Gasto gastoTipo;
    public GastosFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gastos, container, false);
        nomGasto= view.findViewById(R.id.edt_nombre_gasto);
        montoGasto = view.findViewById(R.id.edt_monto_gasto);
        lugarGasto = view.findViewById(R.id.edt_cuenta_gasto);
        fijoGasto = view.findViewById(R.id.rb_fijo_gasto);
        variadoGasto = view.findViewById(R.id.rb_variado_gasto);
        inesperadoGasto = view.findViewById(R.id.rb_inesperado_gasto);

        gastoTipo = new Gasto();

        return inflater.inflate(R.layout.fragment_ingresos, container, false);


    }

    public void RegistrarGasto(View view) {
        if(fijoGasto.isChecked()){
            gastoTipo.setTipo("Gasto fijo");

        }else if(variadoGasto.isChecked()){
            gastoTipo.setTipo("Gasto variado");

        } else if(inesperadoGasto.isChecked()){
            gastoTipo.setTipo("Gasto inesperado");

        }

        if (!nomGasto.getText().toString().equals("") && !montoGasto.getText().toString().equals("") && !lugarGasto.getText().toString().equals("") && !gastoTipo.equals("") ) {
            try {
                OutputStreamWriter createFileInformationUser = new OutputStreamWriter(getActivity().openFileOutput("_bills.txt", Activity.MODE_PRIVATE));

                createFileInformationUser.write(nomGasto.getText().toString() + "\n" + montoGasto.getText().toString() + "\n" + lugarGasto.getText().toString() + "\n" + gastoTipo);
                createFileInformationUser.flush();
                createFileInformationUser.close();
                Toast.makeText(getActivity(), "Gasto registrado correctamente", Toast.LENGTH_SHORT).show();
                Intent registroGasto = new Intent(getActivity(), MainActivity.class);
                startActivity(registroGasto);
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


    public void guardardatos(Gasto gasto) {
        SharedPreferences preferences = getActivity().getSharedPreferences("gastos.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Nombre Gasto", gasto.getNombre());
        editor.putInt("Monto del gasto", gasto.getMonto());
        editor.putString("Lugar del gasto", gasto.getLugar());
        editor.putString("Tipo de gasto", gasto.getTipo());
        editor.apply();
    }

    public void regresarPrincipal(View view) {
        Intent regresarMain = new Intent(getActivity(), MainActivity.class);
        startActivity(regresarMain);

    }



}
