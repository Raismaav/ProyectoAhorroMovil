package com.example.proyectoahorromovil.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.proyectoahorromovil.Modelo.Pago;
import com.example.proyectoahorromovil.R;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PagosFragment extends Fragment {

    View view;
    EditText clave, emisor, receptor, cuenta, monto;
    Button registrarPago;
    CalendarView fechaPago;
    private String usuario;
    private Pago objeto;

    public PagosFragment() { /* Constructor vacío */ }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuario = getActivity().getIntent().getStringExtra("usuario");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pagos, container, false);
        clave = view.findViewById(R.id.edt_clave_pago);
        fechaPago = view.findViewById(R.id.clv_fecha_pago);
        emisor = view.findViewById(R.id.edt_emisor_pago);
        receptor = view.findViewById(R.id.edt_cuenta_pago);
        monto = view.findViewById(R.id.edt_monto_pago);
        cuenta = view.findViewById(R.id.edt_beneficiario_pago);
        registrarPago = view.findViewById(R.id.btn_registrar_pago);
        objeto = new Pago();

        fechaPago.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String fecha = i2 + "/" + i1 + "/" + i;
                objeto.setFechaPago(fecha);
                Toast.makeText(getActivity(), fecha, Toast.LENGTH_SHORT).show();
            }
        });

        registrarPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroPago();
            }
        });

        return view;
    }

    public void registroPago() {
        if(!clave.getText().toString().equals("") && !emisor.getText().toString().equals("") && !receptor.getText().toString().equals("") && !cuenta.getText().toString().equals("") && !monto.getText().toString().equals("")) {
            String claveP = clave.getText().toString();
            String emisorP = emisor.getText().toString();
            String receptorP = receptor.getText().toString();
            String cuentaP = cuenta.getText().toString();
            String montoP = monto.getText().toString();
            objeto.setClaveRastreo(claveP);
            objeto.setEmisor(emisorP);
            objeto.setReceptor(receptorP);
            objeto.setCuentaBeneficiaria(Integer.parseInt(cuentaP));
            objeto.setMontoPago(Integer.parseInt(montoP));
            guardarArchivo();
            limpiar();
            Toast.makeText(getActivity(), "El pago fue registrado con exito.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Revise los campos, alguno esta vacío.", Toast.LENGTH_SHORT).show();
        }
    }

    public void guardarArchivo() {
        try {
            OutputStreamWriter saves = new OutputStreamWriter(getActivity().openFileOutput(usuario + "_payments.txt", Activity.MODE_PRIVATE));
            saves.write("  Clave de rastreo: " + objeto.getClaveRastreo() + "\n Fecha: " + objeto.getFechaPago() + "\n Emisor: " + objeto.getEmisor() + "\n Receptor: " + objeto.getReceptor() + "\n Cuenta beneficiaria: " + objeto.getCuentaBeneficiaria() + "\n Monto: " + objeto.getMontoPago());
            saves.flush();
            saves.close();
        } catch (IOException ex) {
            Toast.makeText(getActivity(), "No se pudo guardar la información en el archivo.", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar() {
        clave.setText("");
        monto.setText("");
        emisor.setText("");
        receptor.setText("");
        cuenta.setText("");
    }
}
