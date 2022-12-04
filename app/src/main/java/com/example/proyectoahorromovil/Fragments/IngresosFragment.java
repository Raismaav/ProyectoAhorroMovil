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
import com.example.proyectoahorromovil.Modelo.Ingreso;
import com.example.proyectoahorromovil.R;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class IngresosFragment extends Fragment {
    EditText nomIngreso,montoIngreso, lugarIngreso;
    RadioButton fijoIngreso,variadoIngreso, esporadicoIngreso;
    public Ingreso ingresoTipo;
    public IngresosFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ingresos, container, false);
        nomIngreso= view.findViewById(R.id.edt_nombre_ingreso);
        montoIngreso = view.findViewById(R.id.edt_monto_ingreso);
        lugarIngreso = view.findViewById(R.id.edt_cuenta_ingreso);
        fijoIngreso = view.findViewById(R.id.rb_fijo_ingreso);
        variadoIngreso = view.findViewById(R.id.rb_variado_ingreso);
        esporadicoIngreso = view.findViewById(R.id.rb_esporadico_ingreso);

        ingresoTipo = new Ingreso();

        return inflater.inflate(R.layout.fragment_ingresos, container, false);


    }

    public void RegistrarIngreso(View view) {
        if(fijoIngreso.isChecked()){
            ingresoTipo.setTipo("Ingreso fijo");

        }else if(variadoIngreso.isChecked()){
            ingresoTipo.setTipo("Ingreso variado");

        } else if(esporadicoIngreso.isChecked()){
            ingresoTipo.setTipo("Ingreso esporadico");

        }

        if (!nomIngreso.getText().toString().equals("") && !montoIngreso.getText().toString().equals("") && !lugarIngreso.getText().toString().equals("") && !ingresoTipo.equals("") ) {
            try {
                OutputStreamWriter createFileInformationUser = new OutputStreamWriter(getActivity().openFileOutput("_incomes.txt", Activity.MODE_PRIVATE));

                createFileInformationUser.write(nomIngreso.getText().toString() + "\n" + montoIngreso.getText().toString() + "\n" + lugarIngreso.getText().toString() + "\n" + ingresoTipo);
                createFileInformationUser.flush();
                createFileInformationUser.close();
                Toast.makeText(getActivity(), "Ingreso registrado correctamente", Toast.LENGTH_SHORT).show();
                Intent registroIngreso = new Intent(getActivity(), MainActivity.class);
                startActivity(registroIngreso);
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


    public void guardardatos(Ingreso ingreso) {
        SharedPreferences preferences = getActivity().getSharedPreferences("ingresos.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Nombre ingreso", ingreso.getNombre());
        editor.putInt("Monto del ingreso", ingreso.getMonto());
        editor.putString("Lugar del ingreso", ingreso.getLugar());
        editor.putString("Tipo de ingreso", ingreso.getTipo());
        editor.apply();
    }

    public void regresarPrincipal(View view) {
        Intent regresarMain = new Intent(getActivity(), MainActivity.class);
        startActivity(regresarMain);

    }



}
