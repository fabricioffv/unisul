package com.teste.fabricio.barberapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Produto_ServicoDAO {
    public ArrayList<Produto_Servico> psList;

    public Produto_ServicoDAO() {
        psList = new ArrayList<>();
    }

    public void listar() {

        try {
            SQLiteDatabase database = DatabaseHelper.getConnection();
            Cursor result = database.query("produtos_servicos", null, null, null, null, null, null);

            while (result.moveToNext()) {
                Produto_Servico ps;
                ps = new Produto_Servico(result.getInt(result.getColumnIndex("id_ps")),
                        result.getString(result.getColumnIndex("nome")),
                        result.getString(result.getColumnIndex("tipo")).charAt(0),
                        result.getDouble(result.getColumnIndex("valor")));
                psList.add(ps);
            }
            database.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Produto_Servico getById(int id) {
        for (int i = 0; i < psList.size(); i++) {
            Produto_Servico ps = psList.get(i);
            if (ps.getId() == id) {
                return ps;
            }
        }
        return null;
    }

    public void inserir(Produto_Servico produto_servico) {
        try {
            SQLiteDatabase database = DatabaseHelper.getConnection();
            ContentValues valores = new ContentValues();
            valores.put("nome", produto_servico.getNome());
            valores.put("tipo", produto_servico.getTipo().toString());
            valores.put("valor", produto_servico.getValor());
            database.insert("produtos_servicos", null, valores);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
