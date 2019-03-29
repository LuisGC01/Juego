package com.example.juego;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class InterfazJuego extends AppCompatActivity {
    Button btnIniciar;
    ImageView lRojo;
    ImageView lAmarillo;
    ImageView lAzul;
    ImageView lVerde;
    TextView cNombre;
    TextView lPuntaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_juego);

        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        lAmarillo = (ImageView) findViewById(R.id.lAmarillo);
        lRojo = (ImageView) findViewById(R.id.lRojo);
        lAzul = (ImageView) findViewById(R.id.lAzul);
        lVerde = (ImageView) findViewById(R.id.iVerde);
        cNombre = (TextView) findViewById(R.id.cNombre);
        lPuntaje = (TextView) findViewById(R.id.lPuntaje);
        lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
        lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
        lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
        lRojo.setBackgroundColor(Color.rgb(255, 0, 0));

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarJuego();
            }
        });

    }


    public void iniciarJuego() {
        new CountDownTimer(3000,1000){
            int l=0,k=0;
            @Override
            public void onTick(long millisUntilFinished) {
                lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
                lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
                lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
                lRojo.setBackgroundColor(Color.rgb(255, 0, 0));
                k=iluminarboton();
                lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
                lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
                lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
                lRojo.setBackgroundColor(Color.rgb(255, 0, 0));
            }

            @Override
            public void onFinish() {
                Log.e("dsd","sdf");
            }
        }.start();
    }

    public int iluminarboton(){
        final int aux = generarAleatorios();

        new CountDownTimer(1000, 20) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (aux == 0) {
                    lVerde.setBackgroundColor(Color.rgb(0, 125, 0));
                } else if (aux == 1) {
                    lRojo.setBackgroundColor(Color.rgb(125, 0, 0));
                } else if (aux == 2) {
                    lAzul.setBackgroundColor(Color.rgb(0, 0, 125));
                } else if (aux == 3) {
                    lAmarillo.setBackgroundColor(Color.rgb(130, 125, 0));
                }

            }

            @Override
            public void onFinish() {
                lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
                lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
                lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
                lRojo.setBackgroundColor(Color.rgb(255, 0, 0));
            }
        }.start();
        return aux;
    }

    public int generarAleatorios() {
        double j = 0;
        int k = 0;
        do {
            j = Math.random() * 10;
            k = (int) j;
        } while (k >= 4);
        return k;
    }


}


