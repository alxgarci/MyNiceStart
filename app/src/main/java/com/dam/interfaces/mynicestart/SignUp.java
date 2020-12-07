package com.dam.interfaces.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignUp extends AppCompatActivity {

    String nombre;
    TextInputEditText usuario;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        usuario = findViewById(R.id.itUsuarioRegistro);
        dato = getIntent().getStringExtra("USUARIO");

        usuario.setText(dato);

    }

    public void signUp(View view) {
        nombre = usuario.getText().toString();
        if (!nombre.isEmpty()) {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("USUARIO", nombre);
            startActivity(i);
        } else {
            Toast.makeText(this, "Introduce un usuario primero",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void cancel(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}