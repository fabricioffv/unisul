/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Classes;

import java.util.ArrayList;

/**
 *
 * @author FabricioF
 */
public abstract class Publicacao {
    private int id_publicacao;
    private String titulo;
    private String autor;
    private int qnt_total;
    private int qnt_disp;
    
    public Publicacao(String titulo, String autor, int qnt_total, int qnt_disp){
        this.titulo = titulo;
        this.autor = autor;
        this.qnt_total = qnt_total;
        this.qnt_disp = qnt_disp;
    }

    public abstract int getCodigo();
    
    public abstract void setCodigo(int codigo);
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getQuantidadeDisponivel() {
        return qnt_disp;
    }

    public boolean temDisponivel(){
        return (qnt_disp > 0);
    }

    /**
     * @return the quantidade_acervo
     */
    public int getQuantidade_Total() {
        return qnt_total;
    }

    /**
     * @param qnt the quantidade_acervo to set
     */
    public void setQuantidade_Total(int qnt) {
        this.qnt_total = qnt;
    }

    /**
     * @return the id_publicacao
     */
    public int getId_publicacao() {
        return id_publicacao;
    }

    /**
     * @param id_publicacao the id_publicacao to set
     */
    public void setId_publicacao(int id_publicacao) {
        this.id_publicacao = id_publicacao;
    }

    public void decrementaDisponivel(){
        this.qnt_disp--;
    }
    
    public void incrementaDisponivel(){
        this.qnt_disp++;
    }
}
