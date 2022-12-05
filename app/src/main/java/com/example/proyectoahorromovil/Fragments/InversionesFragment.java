package com.example.proyectoahorromovil.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.proyectoahorromovil.Modelo.Inversion;
import com.example.proyectoahorromovil.R;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class InversionesFragment extends Fragment {
    private View view;
    private EditText nombreInversion, objetivoInversion, montoInversion;
    private RadioButton plazoCorto, plazoMedio, plazoLargo;
    private CheckBox tipoAccion, tipoBonos, tipoValor;
    private Spinner reisgoInversion;
    private Button registrarInversion;
    private Inversion objeto;
    private String usuario;

    public InversionesFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuario = getActivity().getIntent().getStringExtra("usuario");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_inversiones, container, false);
        nombreInversion = view.findViewById(R.id.edt_nombre_inversion);
        objetivoInversion = view.findViewById(R.id.edt_objetivo_inversion);
        tipoAccion = view.findViewById(R.id.chb_accion);
        tipoBonos = view.findViewById(R.id.chb_bono);
        tipoValor = view.findViewById(R.id.chb_valor);
        reisgoInversion = view.findViewById(R.id.spn_riesgo);
        plazoCorto = view.findViewById(R.id.rb_corto);
        plazoMedio = view.findViewById(R.id.rb_mediano);
        plazoLargo = view.findViewById(R.id.rb_largo);
        montoInversion = view.findViewById(R.id.edt_monto_inversion);
        registrarInversion = view.findViewById(R.id.btn_registrar_inversion);
        objeto = new Inversion();

        registrarInversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroInversion();
            }
        });
        return view;
    }

    public void registroInversion() {
        if(!nombreInversion.getText().toString().equals("") && !objetivoInversion.getText().toString().equals("") && !montoInversion.getText().toString().equals("" ) && reisgoInversion.getSelectedItemPosition() != 0 && (tipoAccion.isChecked() || tipoBonos.isChecked() || tipoValor.isChecked()) && (plazoCorto.isChecked() || plazoMedio.isChecked() || plazoLargo.isChecked())) {
            String nombreI = nombreInversion.getText().toString();
            String objetivoI = objetivoInversion.getText().toString();
            String tipoI = "";
            if (tipoAccion.isChecked()) {
                tipoI += "Acción, ";
            } if (tipoBonos.isChecked()) {
                tipoI += "Bonos, ";
            } if (tipoValor.isChecked()) {
                tipoI += "Mercado de valores, ";
            }
            String riesgoI = reisgoInversion.getSelectedItem().toString();
            String plazoI = "";
            if (plazoCorto.isChecked()) {
                plazoI = "Corto";
            } else if (plazoMedio.isChecked()) {
                plazoI = "Mediano";
            } else if (plazoLargo.isChecked()) {
                plazoI = "Largo";
            }
            String montoI = montoInversion.getText().toString();
            objeto.setNombreInversion(nombreI);
            objeto.setObjetivoInversion(objetivoI);
            objeto.setTipoInversion(tipoI);
            objeto.setNivelRiesgo(riesgoI);
            objeto.setPlazoInversion(plazoI);
            objeto.setMontoInversion(Integer.parseInt(montoI));
            guardarArchivo();
            limpiar();
            Toast.makeText(getActivity(), "La inversión fue registrada con exito..", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Revise los campos, alguno esta vacío.", Toast.LENGTH_SHORT).show();
        }
    }

    public void guardarArchivo() {
        try {
            OutputStreamWriter saves = new OutputStreamWriter(getActivity().openFileOutput(usuario + "_investments.txt", Activity.MODE_PRIVATE));
            saves.write("Nombre: " + objeto.getNombreInversion() + "\nObjetivo: " + objeto.getObjetivoInversion() + "\nTipo: " + objeto.getTipoInversion() + "\nRiesgo: " + objeto.getNivelRiesgo() + "\nPlazo: " + objeto.getPlazoInversion() + "\nMonto: " + objeto.getMontoInversion());
            saves.flush();
            saves.close();
        } catch (IOException ex) {
            Toast.makeText(getActivity(), "No se pudo guardar la información en el archivo.", Toast.LENGTH_SHORT).show();
        }
    }
    public void limpiar() {
        nombreInversion.setText("");
        objetivoInversion.setText("");
        montoInversion.setText("");
        tipoAccion.setChecked(false);
        tipoBonos.setChecked(false);
        tipoValor.setChecked(false);
        plazoCorto.setChecked(false);
        plazoMedio.setChecked(false);
        plazoLargo.setChecked(false);
        reisgoInversion.setSelection(0);
    }
}
