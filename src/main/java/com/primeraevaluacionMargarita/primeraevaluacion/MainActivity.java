package com.primeraevaluacionMargarita.primeraevaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //declaracion de variables
    private Button btnnuevo;
    private Button btnlista;
    public static ArrayList<Estudiante> lstEstudiante;
    public static final  int CODIGONUEVO =1;
    public static final  int CODIGOLISTA =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnnuevo = findViewById(R.id.btnnuevo);
        this.btnlista = findViewById(R.id.btnlista);
        lstEstudiante = new ArrayList<>();
        btnlista.setOnClickListener(this);
        btnnuevo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnnuevo:
                Intent nuevo = new Intent(MainActivity.this,Nuevo.class);
                startActivityForResult(nuevo,CODIGONUEVO);
                break;
            case R.id.btnlista:
                Intent lista = new Intent(MainActivity.this,Lista.class);
                startActivity(lista);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case CODIGONUEVO:
                if(data==null)return;
                String nombre = data.getExtras().getString("NOMBRE");
                String codigo = data.getExtras().getString("CODIGO");
                String materia = data.getExtras().getString("MATERIA");
                Double Nota1 = data.getExtras().getDouble("NOTA1");
                Double Nota2 = data.getExtras().getDouble("NOTA2");
                Double Nota3 = data.getExtras().getDouble("NOTA3");
                Double Promedio= data.getExtras().getDouble("PROMEDIO");
                Estudiante estudiante = new Estudiante(nombre,codigo,materia,Nota1,Nota2,Nota3,Promedio);
                lstEstudiante.add(estudiante);
                btnlista.setText("LISTA DE ESTUDIANTES "+ lstEstudiante.size());
                break;
        }
    }
}
