/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author FabricioF
 */
public class Emprestimo {
    private int codigo;
    private Usuario usuario;
    private Date dataEmprestimo;
    private Date dataEntrega;
    private Date dataDevolucao;
    private SimpleDateFormat sdfAuxiliar = new SimpleDateFormat("dd-MM-yyyy");
    private boolean devolvido;
    private Publicacao publicacao;
    
    public Emprestimo(Usuario usuario, String dataEmprestimo, String dataEntrega, Publicacao publicacao){
        this.codigo = 0;//seta zero pra mandar pro banco
        this.usuario = usuario;
        this.publicacao = publicacao;
        this.devolvido = false;              
        
//        //---------------------------------------------
//        this.dataEmprestimo = new Date();//cria instancia de Date
//        this.dataEntrega = new Date();        
        try{
            this.dataEmprestimo = sdfAuxiliar.parse(dataEmprestimo);
            this.dataEntrega = sdfAuxiliar.parse(dataEntrega);
        }catch (ParseException ex) {
            System.err.println(ex);
        }
        //---------------------------------------------
        
        this.publicacao.decrementaDisponivel();
        
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the dataEmprestimo
     */
    public Date getDataEmprestimo() {
        return this.dataEmprestimo;        
    }

    /**
     * @return the dataDevolucao
     */
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @return the devolvido
     */
    public boolean estaDevolvido() {
        return devolvido;
    }
    
    public void devolver(){
        this.devolvido = true;
    }
    /**
     * @return the publicacao
     */
    public Publicacao getPublicacao() {;
        return publicacao;
    }

    public java.sql.Date converteDateToSqlDate(Date data) {
        if (data == null) {
                return null;
        } else {
                return new java.sql.Date(data.getTime());
        }
    }
    
    public String dataToString(Date d){
        sdfAuxiliar = new SimpleDateFormat("dd/MM/yyyy");
        return sdfAuxiliar.format(d);
    }
    
    public String toString(){
        String msg = "";
        msg = this.codigo + "\n" + this.publicacao.getTitulo() + "\n" + this.usuario.getNome();
        return msg;
    }
    
//    public void dataToString(Date d){
//    System.out.println(d);
//    System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(d));
//    System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(d));
//    System.out.println(d);
//
//    }

    /**
     * @return the dataEntrega
     */
    public Date getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
}
