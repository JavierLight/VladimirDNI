package com.light.letradni;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class main extends ActionBarActivity {

    EditText et_introducedni;
    TextView tv_letra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Relacionamos las variables java con los objetos XML
        et_introducedni= (EditText) findViewById(R.id.et_introducedni);
        tv_letra= (TextView) findViewById(R.id.letra);
    }



   public void calcularletra(View view) {


        //Declaramos en esta función una String para coger el texto del EditText
        String str_dni = et_introducedni.getText().toString();
       //En el caso de que el usuario introduzca un DNI válido:
       int num_digitos=String.valueOf(str_dni).length();    //comprobamos que el DNI introducido tiene una longitud de 8 dígitos
       if (num_digitos==8) {
           //si el DNI es válido, podemos convertirlo a entero sin problemas
        long dni = Integer.parseInt(str_dni);
        char vector_letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int indice = (int) (dni % 23);
        char letra = vector_letras[indice];
        String str_letra = Character.toString(letra);
        tv_letra.setText(str_letra);
        }
       else
        {
            Toast.makeText(getApplicationContext(),"Por favor, introduce un DNI válido.",Toast.LENGTH_LONG).show();
        }

    }


}
