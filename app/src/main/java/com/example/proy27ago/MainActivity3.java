package com.example.proy27ago;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView textView;
    CharSequence items[]={"ITEM 1","ITEM 2","ITEM 3","ITEM 4","ITEM 5","ITEM 6"};
    boolean marcados[] = new boolean[items.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView = findViewById(R.id.txtItems);
        Button button = findViewById(R.id.btnItems);
        Button button1 = findViewById(R.id.btnMostrarA1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                builder = builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("Dialogo con Items")
                        //________________BOTÓN POSITIVO__________
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (i == DialogInterface.BUTTON_POSITIVE){
                                    textView.setText("Ha seleccionado los items");
                                    //Recorrer arreglo
                                    for (int j =0; j < marcados.length; j = j+1 ){
                                        if (marcados[j]){
                                            textView.append("\n"+ items[j]);
                                            if (marcados[5]){
                                                Intent intent;
                                                intent = new Intent(MainActivity3.this,MainActivity2.class);
                                                startActivity(intent);
                                            }
                                        }//if
                                    }//for
                                }//if
                            }//onClick
                        })//setPositiveBotton

                        //--------BOTÓN NEGATIVO-----
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i){
                                textView.setText("Ha cancelado la acción");
                                dialogInterface.cancel();
                            }//onClick
                        })//setNegativeButton
                        //------ESTABLECER LOS ITEMS DEL CUADRO DE DIALOGO
                        .setMultiChoiceItems(items, marcados, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                if (b){
                                    marcados[i]=b;
                                }//if
                                else marcados[i]=false;
                            }//onClick
                        });//setMultiChoiceItems

                //MOSTRAR EL CUADRO DE DIALOGO
                AlertDialog alertDialog= builder.create();
                alertDialog.show();
            }//onClick
        });//setOnClickListener

        //ESCUCHADOR DE BOTÓN QUE INVOCA PRIMERA ACTIVIDAD
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }//onCreate
}//MainActivitys
