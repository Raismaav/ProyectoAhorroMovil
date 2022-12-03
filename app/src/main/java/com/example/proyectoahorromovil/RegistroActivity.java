package com.example.proyectoahorromovil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class RegistroActivity extends AppCompatActivity {

    EditText name, lastname, age, username, passwdUser;
    Spinner sex;
    Button registryUser, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        name = findViewById(R.id.txtNombre);
        lastname = findViewById(R.id.txtApellido);
        age = findViewById(R.id.txtEdad);
        username = findViewById(R.id.txtNombreUsuario);
        passwdUser = findViewById(R.id.txtConstrasenaUusario);
        sex = findViewById(R.id.spSexo);
        registryUser = findViewById(R.id.btnRegistrarUsuario);
        back = findViewById(R.id.btnRegresarLogin);
    }

    public void regresarLogin(View view) {
        Intent loadLogin = new Intent(RegistroActivity.this, LoginActivity.class);
        startActivity(loadLogin);
        finish();
    }

    public void registrarUsuario(View view) {
        if(!name.getText().equals("") && !lastname.getText().equals("") && !age.getText().equals("") && !sex.getSelectedItem().equals("Selecciona") && !username.getText().equals("") && !passwdUser.getText().equals("")) {
            try {
                OutputStreamWriter createFileInformationUser = new OutputStreamWriter(openFileOutput(username.getText().toString() + "_credentials.txt", Activity.MODE_PRIVATE));

                String select = sex.getSelectedItem().toString();
                String sexSelected = "";
                if (select.equals("Femenino")) {
                    sexSelected = "Femenino";
                } else {
                    sexSelected = "Masculino";
                }

                createFileInformationUser.write(name.getText().toString() + "\n" + lastname.getText().toString() + "\n" + age.getText().toString() + "\n" + sexSelected + "\n" + username.getText().toString() + "\n" + passwdUser.getText().toString());
                createFileInformationUser.flush();
                createFileInformationUser.close();
                limpiar();
                Toast.makeText(this, "La cuenta fue creada correctamente.", Toast.LENGTH_SHORT).show();
            } catch (IOException ex) {
                Toast.makeText(this, "La cuenta no pudo crearce de manera correcta.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Revise los campos, alguno se encuentra vacío", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiar() {
        name.setText("");
        lastname.setText("");
        age.setText("");
        username.setText("");
        passwdUser.setText("");
    }

}