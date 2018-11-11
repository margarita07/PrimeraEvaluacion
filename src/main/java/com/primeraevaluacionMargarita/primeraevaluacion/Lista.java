package com.primeraevaluacionMargarita.primeraevaluacion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Lista extends AppCompatActivity {
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        adapter = new AdaptadorEstudiante(Lista.this,MainActivity.lstEstudiante);
        ListView listView = findViewById(R.id.lstEstudiantes);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
