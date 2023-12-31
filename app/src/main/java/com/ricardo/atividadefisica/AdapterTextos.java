package com.ricardo.atividadefisica;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class AdapterTextos extends CursorAdapter {
    public AdapterTextos(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemDaLista = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return itemDaLista;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView lblTexto = view.findViewById(android.R.id.text1);

        String texto = cursor.getString(cursor.getColumnIndexOrThrow("texto"));
        int cor = cursor.getInt(cursor.getColumnIndexOrThrow("cor"));

        lblTexto.setText(texto);
        lblTexto.setTextColor(cor);
    }
}