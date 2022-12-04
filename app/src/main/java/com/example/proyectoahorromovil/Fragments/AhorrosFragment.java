package com.example.proyectoahorromovil.Fragments;


import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.proyectoahorromovil.LoginActivity;
import com.example.proyectoahorromovil.MainActivity;
import com.example.proyectoahorromovil.R;
import com.example.proyectoahorromovil.Modelo.Ahorro;
import com.example.proyectoahorromovil.RegistroActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.io.OutputStreamWriter;
import java.util.Calendar;

public class AhorrosFragment extends Fragment {
    EditText nomAhorro, montoAhorro, cuentaAhorro;
    RadioButton ahorroObjetivo, ahorroEmergencia, AhorroHipotecario;
    int anio, dia, mes;
    CalendarView calendarAhorro;
    Button RegistrarAhor, RegresarAhor;

    public AhorrosFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ahorros, container, false);
        nomAhorro = view.findViewById(R.id.edt_nombre_ahorro);
        montoAhorro = view.findViewById(R.id.edt_monto_ahorro);
        cuentaAhorro = view.findViewById(R.id.edt_cuenta_ahorro);
        ahorroObjetivo = view.findViewById(R.id.rb_objetivo_ahorro);
        ahorroEmergencia = view.findViewById(R.id.rb_emergencia_ahorro);
        AhorroHipotecario = view.findViewById(R.id.rb_hipoteca_ahorro);
        calendarAhorro = view.findViewById(R.id.clv_fecha_ahorro);
        RegistrarAhor = view.findViewById(R.id.btn_registrar_ahorro);
        RegresarAhor = view.findViewById(R.id.btn_regresar_ahorro);


        return inflater.inflate(R.layout.fragment_ahorros, container, false);


    }

   public void RegistrarAhorro(View view) {

        if (!nomAhorro.getText().toString().equals("") && !montoAhorro.getText().toString().equals("") && !cuentaAhorro.getText().toString().equals("") && !ahorroObjetivo.getText().toString().equals("") && !ahorroEmergencia.getText().toString().equals("") && !AhorroHipotecario.getText().toString().equals("")) {
            try {
                OutputStreamWriter createFileInformation = new OutputStreamWriter(getActivity().openFileOutput("_savings.txt", Activity.MODE_PRIVATE));

                createFileInformation.write(nomAhorro.getText().toString() + "\n" + montoAhorro.getText().toString() + "\n" + cuentaAhorro.getText().toString() + "\n" + ahorroObjetivo + "\n" + ahorroEmergencia.getText().toString() + "\n" + AhorroHipotecario.getText().toString());
                createFileInformation.flush();
                createFileInformation.close();
                Toast.makeText(getActivity(), "Registrado correctamente", Toast.LENGTH_SHORT).show();
                Intent registroAhor = new Intent(getActivity(), MainActivity.class);
                startActivity(registroAhor);
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


    public void guardardatos(Ahorro ahorro) {
        SharedPreferences preferences = getActivity().getSharedPreferences("ahorro.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Nombre ahorro", ahorro.getNombreBeneficiario());
        editor.putInt("Monto ahorro", ahorro.getMontoAhorro());
        editor.putString("Cuenta ahorro", ahorro.getCuentaAhorro());
        editor.putString("Tipo ahorro", ahorro.getTipoAhorro());
        editor.apply();
    }

   public void regresarPrincipal(View view) {
        Intent regresarMain = new Intent(getActivity(), MainActivity.class);
        startActivity(regresarMain);

    }
}
