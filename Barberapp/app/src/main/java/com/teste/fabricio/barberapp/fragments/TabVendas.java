package com.teste.fabricio.barberapp.fragments;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.teste.fabricio.barberapp.ListAdapterVendas;
import com.teste.fabricio.barberapp.R;
import com.teste.fabricio.barberapp.VendaDAO;

public class TabVendas extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_vendas, container, false);

        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.listar();

        ListView listView = (ListView) view.findViewById(R.id.listViewVendas);

        ListAdapterVendas listAdapterVendas = new ListAdapterVendas(vendaDAO.vendaList, getActivity());
        listView.setAdapter(listAdapterVendas);
        return view;
    }
}
