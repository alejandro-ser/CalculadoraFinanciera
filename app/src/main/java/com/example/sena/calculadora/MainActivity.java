package com.example.sena.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText edtNum1, edtNum2;
    TextView txtResultado;
    int num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarUI();

        String nombre = null, apellido = null;
        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                nombre = null;
                apellido = null;
            }else{
                nombre = extras.getString("Nombre");
                apellido = extras.getString("Apellido");
            }
        }

        Toast.makeText(MainActivity.this, "Bienvenido "+nombre+" "+apellido, Toast.LENGTH_SHORT).show();
        TextView txtUsuario = (TextView)findViewById(R.id.txtUsuario);
        txtUsuario.setText("Usuario: "+nombre+" "+apellido);

    }

    private void inicializarUI(){
        edtNum1 = (EditText)findViewById(R.id.editTextNum1);
        edtNum2 = (EditText)findViewById(R.id.editTextNum2);

        Button btnSuma = (Button)findViewById(R.id.ButtonBtnSuma);
        Button btnResta = (Button)findViewById(R.id.ButtonBtnResta);
        Button btnMultiplicacion = (Button)findViewById(R.id.ButtonBtnMultiplicacion);
        Button btnDivision = (Button)findViewById(R.id.ButtonBtnDivision);

        txtResultado = (TextView)findViewById(R.id.TextViewResultado);

    }

    protected boolean ObtenerValoresDeCampos() {
        if (edtNum1.getText().toString().isEmpty() || edtNum2.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Debe ingresar los dos numeros",Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            num1 = Integer.parseInt(edtNum1.getText().toString());
            num2 = Integer.parseInt(edtNum2.getText().toString());
            return true;
        }
    }

    public void Suma(View v){
        ObtenerValoresDeCampos();
        int suma = (num1+num2);
        txtResultado.setText("El resultado de la suma es: "+suma);
    }

    public void Resta(View v)
    {
        ObtenerValoresDeCampos();
        int resta = (num1-num2);
        txtResultado.setText("El resultado de la resta es: "+resta);
    }

    public void Multiplicacion(View v){
        ObtenerValoresDeCampos();
        int producto = (num1*num2);
        txtResultado.setText("El producto de la multiplicacion es: "+producto);
    }

    public void Division(View v){
        ObtenerValoresDeCampos();
        int division = (num1/num2);
        txtResultado.setText("El resultado de la division es: "+division);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
