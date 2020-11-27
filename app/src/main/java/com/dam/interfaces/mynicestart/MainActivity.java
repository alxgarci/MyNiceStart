package com.dam.interfaces.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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
}