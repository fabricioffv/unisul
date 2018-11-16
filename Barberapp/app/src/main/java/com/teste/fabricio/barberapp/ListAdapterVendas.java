package com.teste.fabricio.barberapp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapterVendas extends BaseAdapter {

    private final ArrayList<Venda> listVendas;
    private final Activity activity;

    public ListAdapterVendas(ArrayList<Venda> listVendas, Activity activity) {
        this.listVendas = listVendas;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listVendas.size();
    }

    @Override
    public Object getItem(int i) {
        return listVendas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            v = activity.getLayoutInflater().inflate(R.layout.list_vendas, viewGroup, false);
        }

        Venda venda = listVendas.get(i);
        TextView produto = v.findViewById(R.id.textViewProduto);
        TextView data = v.findViewById(R.id.textViewData);
        TextView valor = v.findViewById(R.id.textViewValor);

        produto.setText(venda.getProdSer().getNome());
        data.setText(venda.getdataVenda());
        valor.setText("R$ " + Double.toString(venda.getProdSer().getValor()));
        return v;
    }
}

