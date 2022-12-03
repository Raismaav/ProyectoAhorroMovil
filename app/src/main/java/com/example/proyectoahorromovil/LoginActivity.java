package com.example.proyectoahorromovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {

    EditText user, passwd;
    Button login, registry;
    CheckBox save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.edt_usuario_login);
        passwd = findViewById(R.id.edt_contrasenna_login);
        login = findViewById(R.id.btn_ingresar);
        registry = findViewById(R.id.btn_registrar_login);
        save = findViewById(R.id.chb_guardar);
    }

    public void mandarActivityRegistro(View view) {
        Intent loadRegistry = new Intent(LoginActivity.this, RegistroActivity.class);
        startActivity(loadRegistry);
        finish();
    }

    public void ingresarSitio(View view) {
        if (!user.getText().equals("") && !passwd.getText().equals("")) {
            String files[] = fileList();
            if(archivoExiste(files, user.getText().toString() + "_credentials.txt")) {
                if(save.isChecked()) {
                    try {
                        InputStreamReader contentFiles = new InputStreamReader(openFileInput(user.getText().toString() + "_credentials.txt"));
                        BufferedReader br = new BufferedReader(contentFiles);
                        Usuario userClass = new Usuario();
                            String lineOfName = br.readLine();
                            userClass.setName(lineOfName);
                            String lineOfLastname = br.readLine();
                            userClass.setLastname(lineOfLastname);
                            String lineOfAge = br.readLine();
                            userClass.setAge(Integer.parseInt(lineOfAge));
                            String lineOfSex = br.readLine();
                            userClass.setSex(lineOfSex);
                            String lineOfUsername = br.readLine();
                            userClass.setUsername(lineOfUsername);
                            String lineOfPasswd = br.readLine();
                            userClass.setPasswd(lineOfPasswd);
                            System.out.println(lineOfName + "\n" + lineOfLastname + "\n" + lineOfAge + "\n" + lineOfSex + "\n" + lineOfUsername + "\n" + lineOfPasswd + "\n");
                        br.close();
                        contentFiles.close();
                        guardarPreferencias(userClass);
                        Intent loadMain = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(loadMain);
                        finish();
                    } catch (IOException ex) {
                        Toast.makeText(this, "No se pudieron guardar las preferencias del usuario.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Intent loadMain = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(loadMain);
                    finish();
                }
            } else {
                Toast.makeText(this, "El usuario no existe.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Revise los campos, alguno de ellos se encuentra vacío.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean archivoExiste(String files[], String nameFile) {
        for(int i = 0; i < files.length; i++)
            if(nameFile.equals(files[i]))
                return true;
        return false;
    }

    public void guardarPreferencias(Usuario user) {
        SharedPreferences preferences = getSharedPreferences("user.dat", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Nombre", user.getName());
        editor.putString("Apellido", user.getLastname());
        editor.putInt("Edad", user.getAge());
        editor.putString("Sexo", user.getSex());
        editor.putString("Usuario", user.getUsername());
        editor.putString("Contrasena", user.getPasswd());
        editor.apply();
    }
}