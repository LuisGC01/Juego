package com.example.juego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnIniciar;
    EditText cNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIniciar=(Button)findViewById(R.id.btnIniciar);
        cNombre=(EditText)findViewById(R.id.cNombre);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),InterfazJuego.class);
                i.putExtra("nombre",cNombre.getText().toString());
                startActivity(i);
            }
        });
    }
}
