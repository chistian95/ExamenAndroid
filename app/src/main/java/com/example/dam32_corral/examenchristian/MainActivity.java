package com.example.dam32_corral.examenchristian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    RadioButton rbAlta, rbConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbAlta = (RadioButton) findViewById(R.id.rbAlta);
        rbConsulta = (RadioButton) findViewById(R.id.rbConsulta);
    }

    public void aceptar(View view) {
        if(rbAlta.isChecked()) {
            Intent i = new Intent(this, AltaLibro.class);
            startActivity(i);
        } else if(rbConsulta.isChecked()) {
            Intent i = new Intent(this, ConsultaLibro.class);
            startActivity(i);
        }
    }

    public void salir(View view) {
        finish();
    }
}
