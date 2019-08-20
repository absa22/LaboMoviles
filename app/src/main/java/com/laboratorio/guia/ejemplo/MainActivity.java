package com.laboratorio.guia.ejemplo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int SUMA=1;
    private final int RESTA=2;
    private final int MULTIPLICACION=3;
    private final int DIVISION=4;

    TextView teclado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teclado=findViewById(R.id.teclado);

        //METODO
        teclado.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(teclado, InputMethodManager.SHOW_IMPLICIT);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode){
            case KeyEvent.KEYCODE_S:
                Abrir(SUMA);
            break;
            case KeyEvent.KEYCODE_R:
                Abrir(RESTA);
            break;
            case KeyEvent.KEYCODE_M:
                Abrir(MULTIPLICACION);
            break;
            case KeyEvent.KEYCODE_D:
                Abrir(DIVISION);
                break;

        }
         return super.onKeyDown(keyCode, event);
    }

    private void Abrir(int v){
        Intent op=new Intent(this, Operacion.class);
        op.putExtra("Operador", v);
        startActivityForResult(op, v);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(data!=null) {
                String n1=String.valueOf(data.getExtras().getInt("Primero"));
                String n2=String.valueOf(data.getExtras().getInt("Segundo"));
                String n3=String.valueOf(data.getExtras().getInt("Resultado"));
                switch (requestCode){
                    case SUMA:{
                        Toast.makeText(this, "El resultado de "+n1+"+"+n2+" es: "+n3, Toast.LENGTH_SHORT).show();
                    }
                      break;
                    case RESTA:{
                        Toast.makeText(this, "El resultado de "+n1+"-"+n2+" es: "+n3, Toast.LENGTH_SHORT).show();
                    }
                    break;
                    case MULTIPLICACION:{
                        Toast.makeText(this, "El resultado de "+n1+"*"+n2+" es: "+n3, Toast.LENGTH_SHORT).show();
                    }
                        break;
                    case DIVISION:     {
                          Toast.makeText(this, "El resultado de "+n1+"/"+n2+" es: "+n3, Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
            }
        }else{
            Toast.makeText(this, "No se realizó ninguna operación", Toast.LENGTH_SHORT).show();
        }
    }
}
