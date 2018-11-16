package com.teste.fabricio.barberapp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapterProdutosServicos extends BaseAdapter {

    private final ArrayList<Produto_Servico> listProdutosServicos;
    private final Activity activity;

    public ListAdapterProdutosServicos(ArrayList<Produto_Servico> listProdutosServicos, Activity activity) {
        this.listProdutosServicos = listProdutosServicos;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return (listProdutosServicos == null) ? 0 : listProdutosServicos.size();
    }

    @Override
    public Object getItem(int i) {
        return listProdutosServicos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            v = activity.getLayoutInflater().inflate(R.layout.list_produtosservicos, viewGroup, false);
        }

        Produto_Servico produto_servico = listProdutosServicos.get(i);
        TextView nome = v.findViewById(R.id.textViewNome);
        TextView tipo = v.findViewById(R.id.textViewTipo);
        TextView valor = v.findViewById(R.id.textViewValor);

        nome.setText(produto_servico.getNome());
        if ( produto_servico.getTipo() == 'P' ){
            tipo.setText("Produto");
        } else if ( produto_servico.getTipo() == 'S'){
            tipo.setText("Serviço");
        }
        valor.setText("R$ " + Double.toString(produto_servico.getValor()));
        return v;
    }
}

