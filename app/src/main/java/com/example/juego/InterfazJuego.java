package com.example.juego;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
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
    ArrayList<Integer> h;
    int score = 0;
    int k;
    MediaPlayer sAm;
    MediaPlayer sRo;
    MediaPlayer sAz;
    MediaPlayer sVe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_juego);

        Bundle d= getIntent().getExtras();
        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        lAmarillo = (ImageView) findViewById(R.id.lAmarillo);
        lRojo = (ImageView) findViewById(R.id.lRojo);
        lAzul = (ImageView) findViewById(R.id.lAzul);
        lVerde = (ImageView) findViewById(R.id.iVerde);
        cNombre = (TextView) findViewById(R.id.lNombre);
        lPuntaje = (TextView) findViewById(R.id.lPuntaje);
        colorearBotones();
        score=0;
        g = new ArrayList<Integer>();
        k = g.size();
        sAm=MediaPlayer.create(this, R.raw.c4);
        sRo=MediaPlayer.create(this, R.raw.c2);
        sAz=MediaPlayer.create(this, R.raw.c3);
        sVe=MediaPlayer.create(this, R.raw.c1);
        String s =getIntent().getStringExtra("n");
        cNombre.setText(s);
        btnIniciar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btnIniciar.setEnabled(false);
                lVerde.setEnabled(true);
                lRojo.setEnabled(true);
                lAzul.setEnabled(true);
                lAmarillo.setEnabled(true);
                h = new ArrayList<Integer>();
                /*int l=0;
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
                new CountDownTimer(2000, 2000 / g.size()) {
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
                        btnIniciar.setEnabled(true);
                    }
                }.start();*/
                new CountDownTimer(2000, 1) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        lVerde.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                h.add(0);
                                iluminarBoton(0);
                            }
                        });
                        lRojo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                h.add(1);
                                iluminarBoton(1);
                            }
                        });
                        lAzul.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                h.add(2);
                                iluminarBoton(2);
                            }
                        });
                        lAmarillo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                h.add(3);
                                iluminarBoton(3);
                            }
                        });

                    }

                    @Override
                    public void onFinish() {
                        btnIniciar.setEnabled(true);
                        colorearBotones();
                        lVerde.setEnabled(false);
                        lRojo.setEnabled(false);
                        lAzul.setEnabled(false);
                        lAmarillo.setEnabled(false);


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
            sVe.start();
        } else if (k == 1) {
            lRojo.setBackgroundColor(Color.rgb(125, 0, 0));
            lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
            lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
            lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
            sRo.start();
        } else if (k == 2) {
            lAzul.setBackgroundColor(Color.rgb(0, 0, 125));
            lAmarillo.setBackgroundColor(Color.rgb(255, 255, 0));
            lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
            lRojo.setBackgroundColor(Color.rgb(255, 0, 0));
            sAz.start();
        } else if (k == 3) {
            lAmarillo.setBackgroundColor(Color.rgb(130, 125, 0));
            lAzul.setBackgroundColor(Color.rgb(0, 0, 255));
            lVerde.setBackgroundColor(Color.rgb(0, 255, 0));
            lRojo.setBackgroundColor(Color.rgb(255, 0, 0));
            sAm.start();
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


