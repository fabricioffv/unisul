package com.teste.fabricio.barberapp;

public class Venda {
    private int id;
    private String dataVenda;
    private Produto_Servico prodSer;

    public Venda(int id, String dataVenda, Produto_Servico item) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.prodSer = item;
    }

    public Produto_Servico getProdSer() {
        return prodSer;
    }

    public void setProdSer(Produto_Servico prodSer) {
        this.prodSer = prodSer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdataVenda() {
        return dataVenda;
    }

    public void setdataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
}
