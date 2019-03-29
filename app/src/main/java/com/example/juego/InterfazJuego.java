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

import java.util.ArrayList;
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
    ArrayList<Integer> g;
    int score=0;

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
        g = new ArrayList<Integer>();

        btnIniciar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btnIniciar.setActivated(false);
                iniciarJuego();
            }
        });

    }


    public void iniciarJuego() {

        for(int j = 0; j<=g.size();j++){
            if(score==0 && j==0){
                generarAleatorios();
                iluminarBoton(g.get(j).intValue());
            }else if(score>0&& score==j){
                iluminarBoton(j);
            }

        }
    }
    
    public void iluminarBoton(final int k){
        new CountDownTimer(2000, 2000/k) {
            int c=0;
            @Override
            public void onTick(long millisUntilFinished) {
                int j =g.get(c).intValue();
                if (j == 0) {
                    lVerde.setBackgroundColor(Color.rgb(0, 125, 0));
                } else if (j == 1) {
                    lRojo.setBackgroundColor(Color.rgb(125, 0, 0));
                } else if (j == 2) {
                    lAzul.setBackgroundColor(Color.rgb(0, 0, 125));
                } else if (j == 3) {
                    lAmarillo.setBackgroundColor(Color.rgb(130, 125, 0));
                }
                c++;
            }

            @Override
            public void onFinish() {
                lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
                lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
                lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
                lRojo.setBackgroundColor(Color.rgb(255, 0, 0));
            }
        }.start();
    }



    public void generarAleatorios() {
        double j = 0;
        int k = 0;
        do {
            j = Math.random() * 10;
            k = (int) j;
        } while (k >= 4);
        g.add(k);
    }


}


