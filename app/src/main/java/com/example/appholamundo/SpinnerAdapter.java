package com.example.appholamundo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<SpinnerData> {

    public SpinnerAdapter(Context context, int resource, ArrayList<SpinnerData> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_spinner_layout, parent, false);
        }

        TextView textViewCategoria = convertView.findViewById(R.id.lblCategorias);
        TextView textViewDescripcion = convertView.findViewById(R.id.lblDescripcion);
        ImageView imageView = convertView.findViewById(R.id.imgCategoria);

        SpinnerData currentItem = getItem(position);
        if (currentItem != null) {
            textViewCategoria.setText(currentItem.getTextCategoria());
            textViewDescripcion.setText(currentItem.getTextDescripcion());
            imageView.setImageResource(currentItem.getImageID());
        }

        return convertView;
    }
}
