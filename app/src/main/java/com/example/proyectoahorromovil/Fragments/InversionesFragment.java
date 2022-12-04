package com.example.proyectoahorromovil.Fragments;


import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.proyectoahorromovil.MainActivity;
import com.example.proyectoahorromovil.Modelo.Ingreso;
import com.example.proyectoahorromovil.Modelo.Inversion;
import com.example.proyectoahorromovil.R;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class InversionesFragment extends Fragment {
    EditText nomInversion, objetivoInversion, montoInversion;
    RadioButton accionInversion, bonos, mercadoValores;
    CheckBox BajoRiesgo, medioRiesgo, altoRiesgo, cortoPlazo, medianoPlazo, largoPlazo;
    Inversion inversionTipo, inversionPlazo, inversionRiesgo;

    public InversionesFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inversiones, container, false);
        nomInversion = view.findViewById(R.id.edt_nombre_inversion);
        objetivoInversion = view.findViewById(R.id.edt_objetivo_inversion);
        montoInversion = view.findViewById(R.id.edt_monto_inversion);
        accionInversion = view.findViewById(R.id.rb_accion);
        bonos = view.findViewById(R.id.rb_bonos);
        mercadoValores = view.findViewById(R.id.rb_valores);
        cortoPlazo = view.findViewById(R.id.chb_corto);
        medianoPlazo = view.findViewById(R.id.chb_mediano);
        largoPlazo = view.findViewById(R.id.chb_largo);
        
        inversionRiesgo = new Inversion();
        inversionPlazo = new Inversion();
        inversionTipo = new Inversion();

        return inflater.inflate(R.layout.fragment_inversiones, container, false);
    }

    public void RegistrarInversion(View view) {
        if(accionInversion.isChecked()){
            inversionTipo.setTipoInversion(" Inversion accion");

        }else if(bonos.isChecked()){
            inversionTipo.setTipoInversion("Inversion bonos");

        } else if(mercadoValores.isChecked()){
            inversionTipo.setTipoInversion("Inversion mercado de valores");

        }

        if(BajoRiesgo.isChecked()){
            inversionRiesgo.setNivelRiesgo("Bajo riesgo");
            
        }else if(medioRiesgo.isChecked()){
            inversionRiesgo.setNivelRiesgo("Medio riesgo");
        
        }else if(altoRiesgo.isChecked()){
            inversionRiesgo.setNivelRiesgo("Alto riesgo");
        }

        if(cortoPlazo.isChecked()){
            inversionPlazo.setNivelRiesgo("Corto plazo");

        }else if(medianoPlazo.isChecked()){
            inversionPlazo.setNivelRiesgo("Mediano plazo");

        }else if(largoPlazo.isChecked()){
            inversionPlazo.setNivelRiesgo("Largo plazo");
        }

        if (!nomInversion.getText().toString().equals("") && !montoInversion.getText().toString().equals("") && !objetivoInversion.getText().toString().equals("") && !inversionTipo.equals("")&& !inversionRiesgo.equals("")&& !inversionPlazo.equals("") ) {
            try {
                OutputStreamWriter createFileInformationUser = new OutputStreamWriter(getActivity().openFileOutput("_investments.txt", Activity.MODE_PRIVATE));

                createFileInformationUser.write(nomInversion.getText().toString() + "\n" + montoInversion.getText().toString() + "\n" + objetivoInversion.getText().toString() + "\n" + inversionTipo+ "\n" + inversionPlazo+ "\n" + inversionRiesgo);
                createFileInformationUser.flush();
                createFileInformationUser.close();
                Toast.makeText(getActivity(), "Inversion registrada correctamente", Toast.LENGTH_SHORT).show();
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


    public void guardardatos(Inversion inversion) {
        SharedPreferences preferences = getActivity().getSharedPreferences("inversion.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Nombre de inversion", inversion.getNombreInversion());
        editor.putInt("Monto de inversion", inversion.getMontoInversion());
        editor.putString("Objetivo de inversion", inversion.getObjetivoInversion());
        editor.putString("Tipo de inversion", inversion.getTipoInversion());
        editor.putString("Riesgo de inversion", inversion.getNivelRiesgo());
        editor.putString("Plazo de inversion", inversion.getPlazoInversion());
        editor.apply();
    }

    public void regresarPrincipal(View view) {
        Intent regresarMain = new Intent(getActivity(), MainActivity.class);
        startActivity(regresarMain);

    }

}
