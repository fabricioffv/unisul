package com.teste.fabricio.barberapp.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.teste.fabricio.barberapp.ListAdapterProdutosServicos;
import com.teste.fabricio.barberapp.ListAdapterVendas;
import com.teste.fabricio.barberapp.Produto_ServicoDAO;
import com.teste.fabricio.barberapp.R;
import com.teste.fabricio.barberapp.VendaDAO;

public class TabProdServ extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_prodserv, container, false);

        Produto_ServicoDAO servicoDAO = new Produto_ServicoDAO();
        servicoDAO.listar();

        ListView listView = (ListView) view.findViewById(R.id.listViewProdutosServicos);

        ListAdapterProdutosServicos listAdapterServicos = new ListAdapterProdutosServicos(servicoDAO.psList, getActivity());
        listView.setAdapter(listAdapterServicos);
        return view;
    }
}
