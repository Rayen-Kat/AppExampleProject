package com.martinez.appexampleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {

    private EditText txtNombre, txtApellido, txtEmail, txtPassword, txtConfPass, txtPhone;
    private Spinner spinner;
    private Button btnRegistrar;
    private boolean NombreOk = false;
    private boolean ApellidoOk = false;
    private boolean EmailOk = false;
    private boolean PasswordOk = false;
    private boolean ConfirmacionOk = false;
    private boolean PhoneOk = false;
    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfPass = findViewById(R.id.txtConfPass);
        txtPhone = findViewById(R.id.txtPhone);
        spinner = findViewById(R.id.spinner);
        btnRegistrar = findViewById(R.id.btnRegistro);

        ArrayAdapter<CharSequence> adaptador =
                ArrayAdapter.createFromResource(Registro.this, R.array.genero_array,
                        android.R.layout.simple_spinner_item);
        spinner.setAdapter(adaptador);

        txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 2){
                    txtNombre.setError("Nombre Muy Corto");
                    NombreOk = false;
                }else {
                    NombreOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtApellido.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 2){
                    txtApellido.setError("Apellido Muy Corto");
                    ApellidoOk = false;
                }else {
                    ApellidoOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 5){
                    txtEmail.setError("Email Muy Corto");
                    EmailOk = false;
                }else {
                    EmailOk= true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 8){
                    txtPassword.setError("Contraseña Muy Corta");
                    PasswordOk = false;
                }else {
                    PasswordOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtConfPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (PasswordOk == ConfirmacionOk){
                    txtConfPass.setError("Contraseña no coinside");
                    ConfirmacionOk = false;
                }else {
                    ConfirmacionOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 8){
                    txtPhone.setError("Titulo Muy Corto");
                    PhoneOk = false;
                }else {
                    PhoneOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Registro.this, "Registrado", Toast.LENGTH_SHORT).show();
                String Nombre = txtNombre.getText().toString();
                String Apellido = txtApellido.getText().toString();
                String Correo = txtEmail.getText().toString();
                String Contrasenia = txtPassword.getText().toString();
                String RContrasenia = txtConfPass.getText().toString();
                String Telefono = txtPhone.getText().toString();
                String Genero = spinner.getSelectedItem().toString();
                Usuario usuario = new Usuario(Nombre, Apellido, Correo, Contrasenia,
                        RContrasenia, Telefono, Genero);
                listaUsuarios.add(usuario);
            }
        });
    }

}
