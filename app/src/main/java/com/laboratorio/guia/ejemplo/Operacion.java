package com.laboratorio.guia.ejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Operacion extends AppCompatActivity implements View.OnClickListener {

    Random rand1=new Random();
    Random rand2=new Random();
    private int n1=0;
    private int n2=0;
    private int resultado=0;
    private final int SUMA=1;
    private final int RESTA=2;
    private final int MULTIPLICACION=3;
    private final int DIVISION=4;
    Button prueba;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operacion);
        prueba=findViewById(R.id.prueba);
         n1=rand1.nextInt(200);
         n2=rand2.nextInt(200);

        int operador= getIntent().getIntExtra("Operador", 0);
        switch (operador){
            case SUMA:
                resultado=n1+n2;
                break;
            case RESTA:
                resultado=n1-n2;
                break;
            case MULTIPLICACION:
                resultado=n1*n2;
                break;
            case DIVISION:
                resultado=n1/n2;
                break;
        }


        prueba.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.prueba:{
                Intent i=new Intent();
                i.putExtra("Primero", n1);
                i.putExtra("Segundo", n2);
                i.putExtra("Resultado", resultado);
                setResult(RESULT_OK, i);
                finish();
            }
                break;
        }
    }
}
