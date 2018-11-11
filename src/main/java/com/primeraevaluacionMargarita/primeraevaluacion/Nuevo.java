package com.primeraevaluacionMargarita.primeraevaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Nuevo extends AppCompatActivity {
    private Button btnguardar;
    private EditText txtnombre;
    private EditText txtcodigo;
    private EditText txtmateria;
    private EditText txtnota1;
    private EditText txtnota2;
    private EditText txtnota3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        this.txtnombre = findViewById(R.id.txtnombre);
        this.txtcodigo = findViewById(R.id.txtcodigo);
        this.txtmateria = findViewById(R.id.txtmateria);
        this.txtnota1 = findViewById(R.id.txtnota1);
        this.txtnota2 = findViewById(R.id.txtnota2);
        this.txtnota3 = findViewById(R.id.txtnota3);
        this.btnguardar = findViewById(R.id.btnguardar);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtnombre.getText().toString().isEmpty() && txtcodigo.getText().toString().isEmpty()&&txtmateria.getText().toString().isEmpty()&&txtnota1.getText().toString().isEmpty()&&txtnota2.getText().toString().isEmpty()&&txtnota3.getText().toString().isEmpty()){
                    Toast.makeText(Nuevo.this,"No deje Campos Vacios",Toast.LENGTH_SHORT).show();
                }else{
                    String nombre = txtnombre.getText().toString();
                    String codigo = txtcodigo.getText().toString();
                    String materia = txtmateria.getText().toString();
                    Double Nota1 = Double.parseDouble(txtnota1.getText().toString());
                    Double Nota2 = Double.parseDouble(txtnota2.getText().toString());
                    Double Nota3 = Double.parseDouble(txtnota3.getText().toString());
                    Double Promedio = 0.0;
                    Promedio = (Nota1*0.30)+(Nota2*0.30)+(Nota3*0.40);
                    Intent resultado = new Intent();
                    resultado.putExtra("NOMBRE",nombre);
                    resultado.putExtra("CODIGO",codigo);
                    resultado.putExtra("MATERIA",materia);
                    resultado.putExtra("NOTA1",Nota1);
                    resultado.putExtra("NOTA2",Nota2);
                    resultado.putExtra("NOTA3",Nota3);
                    resultado.putExtra("PROMEDIO",Promedio);
                    setResult(MainActivity.CODIGONUEVO,resultado);
                    finish();
                }

            }
        });
    }
}
