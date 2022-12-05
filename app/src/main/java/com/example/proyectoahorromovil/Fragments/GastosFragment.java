package com.example.proyectoahorromovil.Fragments;

import android.app.Activity;
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

import com.example.proyectoahorromovil.Modelo.Gasto;
import com.example.proyectoahorromovil.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GastosFragment extends Fragment {

    View view;
    EditText nombre, monto, lugar;
    RadioButton gastoFijo, gastoVariado, gastoInesperado;
    Button registrarGasto;
    CalendarView fechaGasto;
    private String usuario;
    private Gasto objeto;

    public GastosFragment() { /* Constructor vacío */ }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuario = getActivity().getIntent().getStringExtra("usuario");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gastos, container, false);
        nombre = view.findViewById(R.id.edt_nombre_gasto);
        gastoFijo = view.findViewById(R.id.rb_fijo_gasto);
        gastoVariado = view.findViewById(R.id.rb_variado_gasto);
        gastoInesperado = view.findViewById(R.id.rb_inesperado_gasto);
        fechaGasto = view.findViewById(R.id.clv_fecha_gasto);
        monto = view.findViewById(R.id.edt_monto_gasto);
        lugar = view.findViewById(R.id.edt_cuenta_gasto);
        registrarGasto = view.findViewById(R.id.btn_registrar_gasto);
        objeto = new Gasto();

        fechaGasto.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String fecha = i2 + "/" + i1 + "/" + i;
                objeto.setFechaMovimiento(fecha);
                Toast.makeText(getActivity(), fecha, Toast.LENGTH_SHORT).show();
            }
        });

        registrarGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroGasto();
            }
        });

        return view;
    }

    public void registroGasto() {
        if(!nombre.getText().toString().equals("") && !monto.getText().toString().equals("") && !lugar.getText().toString().equals("") && (gastoFijo.isChecked() || gastoVariado.isChecked() || gastoInesperado.isChecked())) {
            String nombreG = nombre.getText().toString();
            String tipoG= "";
            if (gastoFijo.isChecked()) {
                tipoG = "Gastos fijos";
            } else if (gastoVariado.isChecked()) {
                tipoG = "Gastos variados";
            } else if (gastoInesperado.isChecked()) {
                tipoG = "Gastos inesperados";
            }
            String montoG = monto.getText().toString();
            String lugarG = lugar.getText().toString();
            objeto.setNombreMovimiento(nombreG);
            objeto.setTipoGasto(tipoG);
            objeto.setMontoMovimiento(Integer.parseInt(montoG));
            objeto.setLugarGasto(lugarG);
            guardarArchivo();
            limpiar();
            Toast.makeText(getActivity(), "El gasto fue registrado con exito.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Revise los campos, alguno esta vacío.", Toast.LENGTH_SHORT).show();
        }
    }

    public void guardarArchivo() {
        try {
            String anterior = obtenerAnteriores(usuario + "_bills.txt");
            OutputStreamWriter saves = new OutputStreamWriter(getActivity().openFileOutput(usuario + "_bills.txt", Activity.MODE_PRIVATE));
            saves.write(anterior + " Concepto: " + objeto.getNombreMovimiento() + "\n Tipo: " + objeto.getTipoGasto() + "\n Fecha: " + objeto.getFechaMovimiento() + "\n Monto: " + objeto.getMontoMovimiento() + "\n Lugar: " + objeto.getLugarGasto() + "\n\n");
            saves.flush();
            saves.close();
        } catch (IOException ex) {
            Toast.makeText(getActivity(), "No se pudo guardar la información en el archivo.", Toast.LENGTH_SHORT).show();
        }
    }

    private String obtenerAnteriores(String nombreArchivo) {
        try {
            InputStreamReader archivoInterno = new InputStreamReader(getActivity().openFileInput(nombreArchivo));
            BufferedReader leerArchivo = new BufferedReader(archivoInterno);
            String linea = leerArchivo.readLine();
            String textoLeido = "";

            while (linea != null) {
                textoLeido += linea + "\n";
                linea = leerArchivo.readLine();
            }
            leerArchivo.close();
            archivoInterno.close();
            return textoLeido;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void limpiar() {
        nombre.setText("");
        monto.setText("");
        lugar.setText("");
        gastoFijo.setChecked(false);
        gastoVariado.setChecked(false);
        gastoInesperado.setChecked(false);
    }
}
