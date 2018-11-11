package com.primeraevaluacionMargarita.primeraevaluacion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorEstudiante extends ArrayAdapter<Estudiante> {

    public AdaptadorEstudiante(@NonNull Context context, List<Estudiante> object) {
        super(context, 0,object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Estudiante estudiante = getItem(position);

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_estudiante,parent,false);
        }

        TextView lblcontador = convertView.findViewById(R.id.lblContador);
        TextView lblnombre = convertView.findViewById(R.id.lblNombre);
        TextView lblcodigo = convertView.findViewById(R.id.lblcodigo);
        TextView lblmateria = convertView.findViewById(R.id.lblmateria);
        TextView lblpromedio = convertView.findViewById(R.id.lblpromedio);
        lblcontador.setText(String.valueOf(position+1));
        lblnombre.setText(estudiante.Nombres);
        lblcodigo.setText(estudiante.Codigo);
        lblmateria.setText(estudiante.Materia);
        lblpromedio.setText("    "+String.valueOf(estudiante.Promedio));
        return convertView;
    }
}
