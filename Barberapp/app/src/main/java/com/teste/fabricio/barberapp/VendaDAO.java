package com.teste.fabricio.barberapp;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class VendaDAO {
    public ArrayList<Venda> vendaList;

    public VendaDAO() {
        vendaList = new ArrayList<>();
    }

    public void listar() {
        try {
            Produto_Servico ps = null;
            SQLiteDatabase database = DatabaseHelper.getConnection();
            String sql = "select  v.id_venda, v.data_venda, ps.* from vendas v inner join produtos_servicos ps on ps.id_ps = v.id_ps";
            Cursor result = database.rawQuery(sql, null);
            result.moveToFirst();

            while (!result.isAfterLast()) {
                int id_venda = result.getInt(result.getColumnIndex("id_venda"));
                String data_venda = result.getString(result.getColumnIndex("data_venda"));

                //Produto/Serviço
                ps = new Produto_Servico(result.getInt(result.getColumnIndex("id_ps")),
                        result.getString(result.getColumnIndex("nome")),
                        result.getString(result.getColumnIndex("tipo")).charAt(0),
                        result.getDouble(result.getColumnIndex("valor")));
                vendaList.add(new Venda(id_venda, data_venda, ps));
                result.moveToNext();
            }
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserir(Venda venda) {
        try {
            SQLiteDatabase database = DatabaseHelper.getConnection();
            ContentValues valores = new ContentValues();
            valores.put("data_venda", venda.getdataVenda());
            valores.put("id_ps", venda.getProdSer().getId());
            database.insert("vendas", null, valores);
            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Venda getById(int id) {
        for (int i = 0; i < vendaList.size(); i++) {
            Venda v = vendaList.get(i);
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
}
