package com.example.proyectoahorromovil.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.proyectoahorromovil.MainActivity;
import com.example.proyectoahorromovil.Modelo.Ingreso;
import com.example.proyectoahorromovil.R;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class IngresosFragment extends Fragment {

    private View view;
    private EditText nombre, monto, lugar;
    private RadioButton rb_fijo_ingreso, rb_variado_ingreso, rb_esporadico_ingreso;
    private Button registrarIngreso;
    private CalendarView fechaIngreso;
    private String usuario;
    private Ingreso objeto;

    public IngresosFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuario = getActivity().getIntent().getStringExtra("usuario");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ingresos, container, false);
        nombre = view.findViewById(R.id.edt_nombre_ingreso);
        rb_fijo_ingreso = view.findViewById(R.id.rb_fijo_ingreso);
        rb_variado_ingreso = view.findViewById(R.id.rb_variado_ingreso);
        rb_esporadico_ingreso = view.findViewById(R.id.rb_esporadico_ingreso);
        fechaIngreso = view.findViewById(R.id.clv_fecha_ingreso);
        monto = view.findViewById(R.id.edt_monto_ingreso);
        lugar = view.findViewById(R.id.edt_lugar_ingreso);
        registrarIngreso = view.findViewById(R.id.btn_registrar_ingreso);
        objeto = new Ingreso();

        fechaIngreso.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String fecha = i2 + "/" + i1 + "/" + i;
                objeto.setFechaMovimiento(fecha);
                Toast.makeText(getActivity(), fecha, Toast.LENGTH_SHORT).show();
            }
        });

        registrarIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroIngreso();
            }
        });
        return view;
    }

    public void registroIngreso() {
        if(!nombre.getText().toString().equals("") && !monto.getText().toString().equals("") && !lugar.getText().toString().equals("") && (rb_fijo_ingreso.isChecked() || rb_variado_ingreso.isChecked() || rb_esporadico_ingreso.isChecked())) {
            String nombreI = nombre.getText().toString();
            String tipoI = "";
            if (rb_fijo_ingreso.isChecked()) {
                tipoI = "Ingreso fijo";
            } else if (rb_variado_ingreso.isChecked()) {
                tipoI = "Ingreso variado";
            } else if (rb_esporadico_ingreso.isChecked()) {
                tipoI = "Ingreso esporádico";
            }
            String montoI = monto.getText().toString();
            String lugarI = lugar.getText().toString();
            objeto.setNombreMovimiento(nombreI);
            objeto.setTipoIngreso(tipoI);
            objeto.setMontoMovimiento(Integer.parseInt(montoI));
            objeto.setLugarIngreso(lugarI);
            guardarArchivo();
            limpiar();
            Toast.makeText(getActivity(), "El ingreso fue registrado con exito..", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Revise los campos, alguno esta vacío.", Toast.LENGTH_SHORT).show();
        }
    }

    public void guardarArchivo() {
        try {
            OutputStreamWriter saves = new OutputStreamWriter(getActivity().openFileOutput(usuario + "_incomes.txt", Activity.MODE_PRIVATE));
            saves.write(" Concepto: " + objeto.getNombreMovimiento() + "\n Tipo: " + objeto.getTipoIngreso() + "\n Fecha: " + objeto.getFechaMovimiento() + "\n Monto: " + objeto.getMontoMovimiento() + "\n Lugar: " + objeto.getLugarIngreso());
            saves.flush();
            saves.close();
        } catch (IOException ex) {
            Toast.makeText(getActivity(), "No se pudo guardar la información en el archivo.", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar() {
        nombre.setText("");
        monto.setText("");
        lugar.setText("");
        rb_fijo_ingreso.setChecked(false);
        rb_variado_ingreso.setChecked(false);
        rb_esporadico_ingreso.setChecked(false);
    }
}
