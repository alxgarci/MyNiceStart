package com.dam.interfaces.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Main con boton de continuar
 * @author alex
 */

public class MainActivity extends AppCompatActivity {

    private TextView textoBienv;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = getIntent().getStringExtra("USUARIO");

        textoBienv = findViewById(R.id.txtBienvenida);
        textoBienv.setText(String.format(getResources().getString(R.string.txt_bienvenida), nombre));

    }

    public void continuar(View view) {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}