package com.example.juego;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

        btnIniciar=(Button)findViewById(R.id.btnIniciar);
        lAmarillo=(ImageView)findViewById(R.id.lAmarillo);
        lRojo=(ImageView)findViewById(R.id.lRojo);
        lAzul=(ImageView)findViewById(R.id.lAzul);
        lVerde=(ImageView)findViewById(R.id.iVerde);
        cNombre=(TextView)findViewById(R.id.cNombre);
        lPuntaje=(TextView)findViewById(R.id.lPuntaje);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarJuego();
            }
        });

    }

    public void iniciarJuego(){


        new CountDownTimer(2000,20){
            int aux=generarAleatorios();
            @Override
            public void onTick(long millisUntilFinished) {
                destacarImagenes(aux);
            }

            @Override
            public void onFinish() {
                lAmarillo.setColorFilter(Color.rgb(255,255,0));
                lAzul.setColorFilter(Color.rgb(0,0,255));
                lVerde.setColorFilter(Color.rgb(0,255,0));
                lRojo.setColorFilter(Color.rgb(255,0,0));
            }
        }.start();

    }

    public int generarAleatorios(){
        double j = 0;
        int k = 0;
        do {
            j =Math.random()*10;
            k =(int)j;
        }while (k>=4);
        return k;
    }

    public void destacarImagenes(int a){
        switch (a){
            case 0:
                lVerde.setColorFilter(Color.rgb(0,125,0));
                break;
            case 1:
                lRojo.setColorFilter(Color.rgb(125,0,0));
                break;
            case 2:
                lAzul.setColorFilter(Color.rgb(0,0,125));
                break;
            case 3:
                lAmarillo.setColorFilter(Color.rgb(130,125,0));
                break;

        }
    }
}
