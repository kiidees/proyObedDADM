package com.example.proy27ago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;


public class MainActivity2 extends AppCompatActivity {
    Button button;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.button);

        //Escuchador
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View view) {
                progressDialog = new ProgressDialog(MainActivity2.this);
                progressDialog.setMax(100);
                progressDialog.setMessage("Descargando...");
                progressDialog.setTitle("Dialogo de barra de progreso");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();

                //Programar el comportamiento de la interfaz en un hilo
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (progressDialog.getProgress() <= progressDialog.getMax()) {
                                //
                                Thread.sleep(200);
                                handler.sendMessage(handler.obtainMessage());
                                if (progressDialog.getProgress() == progressDialog.getMax()){
                                    progressDialog.dismiss();
                                }//if
                            }//while
                        } catch (Exception e) {
                            e.printStackTrace();
                        }//catch

                    }//run
                }).start();

            }//onClick

            Handler handler = new Handler(){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    progressDialog.incrementProgressBy(1);
                }//handleMessage
            };
        });//setOnClickListener

    }//OnCreate
}//MainActivity2