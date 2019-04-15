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
    int score = 0;
    int k;

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
        colorearBotones();
        score=0;
        g = new ArrayList<Integer>();
        k = g.size();
        btnIniciar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btnIniciar.setActivated(false);
                int l=0;
                if(g.size()<1){
                    l=generarAleatorios();
                }else{
                    do{
                        l=generarAleatorios();
                    }while (g.get(g.size()-1)==l);
                }
                Log.e("n",""+l);
                g.add(l);
                lPuntaje.setText(""+score);
                new CountDownTimer(1000, 1000 / g.size()) {
                    int c = 0;

                    @Override
                    public void onTick(long millisUntilFinished) {
                        colorearBotones();
                        try {
                            if (c < g.size()) {
                                lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
                                lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
                                lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
                                lRojo.setBackgroundColor(Color.rgb(255, 0, 0));
                                iluminarBoton(g.get(c));
                                c++;
                            }
                        } catch (Exception e) {
                            Log.e("El error", e.getMessage());
                        }
                    }

                    @Override
                    public void onFinish() {
                        colorearBotones();
                    }
                }.start();
                score++;
            }
        });


    }


    public void colorearBotones() {
        lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
        lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
        lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
        lRojo.setBackgroundColor(Color.rgb(255, 0, 0));
    }

    public void iluminarBoton(int k) {
        colorearBotones();
        if (k == 0) {
            lVerde.setBackgroundColor(Color.rgb(0, 125, 0));
            lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
            lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
            lRojo.setBackgroundColor(Color.rgb(255, 0, 0));
        } else if (k == 1) {
            lRojo.setBackgroundColor(Color.rgb(125, 0, 0));
            lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
            lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
            lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
        } else if (k == 2) {
            lAzul.setBackgroundColor(Color.rgb(0, 0, 125));
            lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
            lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
            lRojo.setBackgroundColor(Color.rgb(255, 0, 0));
        } else if (k == 3) {
            lAmarillo.setBackgroundColor(Color.rgb(130, 125, 0));
            lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
            lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
            lRojo.setBackgroundColor(Color.rgb(255, 0, 0));

        }

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


