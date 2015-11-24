package com.example.sena.calculadora;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Financiera extends ActionBarActivity {

    EditText edtValorVehiculo, edtCuotaInicial, edtCredito, edtTasaInteres;
    Spinner spnrPlazo;
    TextView txtResultado;
    int valorVehiculo, cuotaInicial, credito, tasaInteres, plazo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financiera);

        inicializarUI();
    }

    private void inicializarUI(){
        edtValorVehiculo = (EditText)findViewById(R.id.valorVehiculo);
        edtCuotaInicial = (EditText)findViewById(R.id.cuotaInicial);
        edtCredito = (EditText)findViewById(R.id.credito);
        edtTasaInteres = (EditText)findViewById(R.id.tasaInteres);

        spnrPlazo = (Spinner)findViewById(R.id.plazo);

        txtResultado = (TextView)findViewById(R.id.txtResultado);
    }

    protected boolean ObtenerValoresDeCampos() {
        if (edtValorVehiculo.getText().toString().isEmpty() || edtCuotaInicial.getText().toString().isEmpty() || edtCredito.getText().toString().isEmpty() || edtTasaInteres.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Todos los campos deben tener un valor..", Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            valorVehiculo = Integer.parseInt(edtValorVehiculo.getText().toString());
            cuotaInicial = Integer.parseInt(edtCuotaInicial.getText().toString());
            credito = Integer.parseInt(edtCredito.getText().toString());
            tasaInteres = Integer.parseInt(edtTasaInteres.getText().toString());
            plazo = Integer.parseInt(spnrPlazo.getSelectedItem().toString());
            return true;
        }
    }

    public void calculo(View v){
        ObtenerValoresDeCampos();
        float resultado = calculoCuota(credito, plazo, tasaInteres);
        resultado = Math.round(resultado);
        int cuota = (int)resultado;
        int total = plazo * 12 * cuota;
        txtResultado.setText("Cuouta mensual del credito $"+cuota+"\nSi el valor de su crédito fue $"+credito+", el pago total que pagará por el préstamo será aproximadamente de $"+total);
    }

    protected float calculoCuota(float credito, float plazo, float tasaInteres) {
        float cuota;
        float tasa = tasaInteres / 100;
        float meses = plazo * 12;
        float m = meses * -1;
        float interes = tasa + 1;

        cuota = (float) ((credito * tasa) / (1 - Math.pow(interes, m)));

        return cuota;
    }



}
