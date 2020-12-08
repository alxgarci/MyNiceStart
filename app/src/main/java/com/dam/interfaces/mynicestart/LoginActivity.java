package com.dam.interfaces.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Ventana login
 * @author alex
 */

public class LoginActivity extends AppCompatActivity {

    TextInputEditText nombreEdit;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombreEdit = findViewById(R.id.itUsuario);


    }

    public void loginMain(View view) {
        usuario = nombreEdit.getText().toString();
        if (!usuario.isEmpty()) {
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            i.putExtra("USUARIO", usuario);
            startActivity(i);
        } else {
            Toast.makeText(this, "Introduce un usuario primero",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void goSignUp(View view) {
        usuario = nombreEdit.getText().toString();
        Intent i = new Intent(this, SignUp.class);
        if (!usuario.isEmpty()) {
            i.putExtra("USUARIO", usuario);
        }
        startActivity(i);
    }
}