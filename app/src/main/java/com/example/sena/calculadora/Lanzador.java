package com.example.sena.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class Lanzador extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanzador);
    }

    public void LanzarCalculadoraBasica(View v)
    {
        Intent myIntent = new Intent();
        myIntent.setClass(Lanzador.this,MainActivity.class);
        myIntent.putExtra("Nombre", "Alejandro ");
        myIntent.putExtra("Apellido", "Serna");
        startActivity(myIntent);
        overridePendingTransition(android.support.v7.appcompat.R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
    }

    public void LsnzarCalculadoraFinanciera(View v){
        Intent myIntent = new Intent();
        myIntent.setClass(Lanzador.this,Financiera.class);
        startActivity(myIntent);
        overridePendingTransition(android.support.v7.appcompat.R.anim.abc_slide_in_bottom,R.anim.abc_slide_out_bottom);
    }

}
