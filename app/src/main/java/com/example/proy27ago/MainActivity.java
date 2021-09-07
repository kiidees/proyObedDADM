package com.example.proy27ago;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;  //Variable global a la clase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DECLRACIÓN DE VARIABLES
        Button botondialogo = findViewById(R.id.btnDialogo);
        tv = findViewById(R.id.lblBotonPulsado);

        //Crear un escuchador
        botondialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Este es un dialogo con botones");
                builder.setMessage("Desea salir del sistema?");
                builder.setCancelable(false);

                builder.setPositiveButton("sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv.setText("Botón SI pulsado");
                        MainActivity.this.finish();
                    }//onClick
                });//setPositiveButton
                //--------------------------------------------
                builder.setNeutralButton("Botón Neutro", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv.setText("Botón NEUTRO pulsado");
                    }//onClick
                });//setNeutralButton
                //--------------------------------------------
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tv.setText("Botón NO pulsado");
                        dialogInterface.cancel();
                    }//onclick
                });//setNegativeButton
                //-----------------------------------------
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }//onClick
        });//setOnClickListener
    }//ONCREATE
}//MAINCREATE