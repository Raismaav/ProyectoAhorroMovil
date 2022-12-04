package com.example.proyectoahorromovil.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.proyectoahorromovil.R;
import com.example.proyectoahorromovil.Modelo.Ahorro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AhorrosFragment extends Fragment {

    private View view;
    private EditText nombre, monto, cuenta;
    private RadioButton ahorroObjetivo, ahorroEmergencia, ahorroHipotecario;
    private Button registrarAhorro;
    private CalendarView fechaAhorro;
    private String usuario;
    private Ahorro objeto;

    public AhorrosFragment() { /* Constructor vacío */ }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuario = getActivity().getIntent().getStringExtra("usuario");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ahorros, container, false);
        nombre = view.findViewById(R.id.edt_nombre_ahorro);
        ahorroObjetivo = view.findViewById(R.id.rb_objetivo_ahorro);
        ahorroEmergencia = view.findViewById(R.id.rb_emergencia_ahorro);
        ahorroHipotecario = view.findViewById(R.id.rb_hipoteca_ahorro);
        fechaAhorro = view.findViewById(R.id.clv_fecha_ahorro);
        monto = view.findViewById(R.id.edt_monto_ahorro);
        cuenta = view.findViewById(R.id.edt_cuenta_ahorro);
        registrarAhorro = view.findViewById(R.id.btn_registrar_ahorro);
        objeto = new Ahorro();

        fechaAhorro.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String fecha = i2 + "/" + i1 + "/" + i;
                objeto.setFechaAhorro(fecha);
                Toast.makeText(getActivity(), fecha, Toast.LENGTH_SHORT).show();
            }
        });

        registrarAhorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroAhorro();
            }
        });

        return view;
    }

    public void registroAhorro() {
        if(!nombre.getText().toString().equals("") && !monto.getText().toString().equals("") && !cuenta.getText().toString().equals("") && (ahorroObjetivo.isChecked() || ahorroEmergencia.isChecked() || ahorroHipotecario.isChecked())) {
            String nombreB = nombre.getText().toString();
            String tipoA = "";
                if (ahorroObjetivo.isChecked()) {
                    tipoA = "Ahorro para un objetivo";
                } else if (ahorroEmergencia.isChecked()) {
                    tipoA = "Ahorro de emergencia";
                } else if (ahorroHipotecario.isChecked()) {
                    tipoA = "Ahorro hipotecario";
                }
           String montoA = monto.getText().toString();
           String cuentaA = cuenta.getText().toString();
               objeto.setNombreBeneficiario(nombreB);
               objeto.setTipoAhorro(tipoA);
               objeto.setMontoAhorro(Integer.parseInt(montoA));
               objeto.setCuentaAhorro(cuentaA);
           guardarArchivo();
           limpiar();
           Toast.makeText(getActivity(), "El ahorro fue registrado con exito..", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Revise los campos, alguno esta vacío.", Toast.LENGTH_SHORT).show();
        }
    }

    public void guardarArchivo() {
        try {
            OutputStreamWriter saves = new OutputStreamWriter(getActivity().openFileOutput(usuario + "_savings.txt", Activity.MODE_PRIVATE));
            saves.write(objeto.getNombreBeneficiario() + "\n" + objeto.getTipoAhorro() + "\n" + objeto.getFechaAhorro() + "\n" + objeto.getMontoAhorro() + "\n" + objeto.getCuentaAhorro());
            saves.flush();
            saves.close();
        } catch (IOException ex) {
            Toast.makeText(getActivity(), "No se pudo guardar la información en el archivo.", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar() {
        nombre.setText("");
        monto.setText("");
        cuenta.setText("");
        ahorroObjetivo.setChecked(false);
        ahorroEmergencia.setChecked(false);
        ahorroHipotecario.setChecked(false);
    }
}
