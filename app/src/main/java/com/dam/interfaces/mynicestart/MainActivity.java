package com.dam.interfaces.mynicestart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

/**
 * Main con boton de continuar
 * @author alex
 */

public class MainActivity extends AppCompatActivity {

    TextView textoBienv;
    String nombre;
    SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = getIntent().getStringExtra("USUARIO");

        textoBienv = findViewById(R.id.txtBienvenida);
        textoBienv.setText(String.format(getResources().getString(R.string.txt_bienvenida), nombre));
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        ExpandableCardView card = findViewById(R.id.cvExpandableCardView);
        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                Toast.makeText(MainActivity.this, "EXPANDIDO", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // ** DIALOGO MODAL **
    public void showAlertDialogButtonClicked(MainActivity view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //el dialogo estandar tiene título/icono pero podemos sustituirlo
        //por un XML a medida
        builder.setTitle("Dialog");
        builder.setMessage("Seguro que quieres continuar?");
        builder.setIcon(R.drawable.ic_candado);
        // un XML a medida para el diálogo

//            builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view,
//                    null));
//
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent o = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(o);
            }
        });

        builder.setNegativeButton("Cancelar", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
//        rface().OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // do something like...
//                dialog.dismiss();
//            }
//        });
//        builder.setNegativeButton("ChatBot", new
//                DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // do something like...
//                        dialog.dismiss();
//                    }
//                });
//
//        builder.setNeutralButton("MotionLayout", new
//                DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // do something like...
//                        dialog.dismiss();
//                    }
//                });
//        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void continuar(View view) {
        showAlertDialogButtonClicked(MainActivity.this);
        //TODO: SHOW ALERT DIALOG
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itmSalir:
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);
        return true;
    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.amLayout);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipeLayout.setRefreshing(false);
        }
    };
}