package com.example.basicmediaplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Adaptador extends BaseAdapter {
    private Context ctx;
    private int [] lista;

    public Adaptador(Context ctx, int[] lista) {
        this.ctx = ctx;
        this.lista = lista;
    }

    @Override
    public int getCount() { // Retorna quantos elementos tem na lista
        return lista.length;
    }

    @Override
    public Object getItem(int i) {
        return lista[i]; //retorna o item da lista
    }

    @Override
    public long getItemId(int i) { // retorna a posicao do item na lista
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView image= new ImageView(ctx);
        image.setImageResource(lista[i]);
        image.setLayoutParams(new ViewGroup.LayoutParams(600,600));
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setPadding(5,5,5,5);

        return image;
    }
}
