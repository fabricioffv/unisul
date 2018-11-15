/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.DAOs;

import biblioteca.Classes.Conexao;
import biblioteca.Classes.Emprestimo;
import biblioteca.Classes.Livro;
import biblioteca.Classes.Periodico;
import biblioteca.Classes.Publicacao;
import biblioteca.Classes.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabricio
 */
public class EmprestimoDAO{
    private Connection con = null;
    private PreparedStatement ps = null;

    
    public boolean inserir(Emprestimo e) throws SQLException{
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("INSERT INTO EMPRESTIMO(id_emprestimo, id_usuario, id_publicacao, data_emprestimo, data_entrega, data_devolucao, devolvido) VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setInt(2, e.getUsuario().getId_usuario());
            ps.setInt(3, e.getPublicacao().getId_publicacao());
            ps.setDate(4, e.converteDateToSqlDate(e.getDataEmprestimo()));
            ps.setDate(5, e.converteDateToSqlDate(e.getDataEntrega()));
            ps.setDate(6, null);
            ps.setInt(7, 0);
            
            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    
    public ArrayList<Emprestimo> consultar(Publicacao p) throws SQLException{
        ArrayList<Emprestimo> lista = null;
        ResultSet rs = null;
        Emprestimo e = null;
        Usuario u = null;
        Publicacao pu = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT U.id_usuario, U.matricula, U.nome, E.id_emprestimo, E.data_emprestimo, E.data_entrega, E.devolvido, P.titulo, P.autor,"
                    + " P.num_total, P.num_disponivel, L.id_livro, L.isbn, E.data_devolucao FROM EMPRESTIMO AS E "
                    + " INNER JOIN USUARIO AS U ON (E.ID_USUARIO = U.ID_USUARIO) "
                    + " INNER JOIN PUBLICACAO AS P ON (E.ID_PUBLICACAO = P.ID_PUBLICACAO)"
                    + " INNER JOIN LIVRO AS L ON (L.ID_LIVRO = P.ID_PUBLICACAO) WHERE E.ID_PUBLICACAO = ? ORDER BY E.DATA_EMPRESTIMO DESC");
            ps.setInt(1, p.getId_publicacao());
            rs = ps.executeQuery();
            lista = new ArrayList<Emprestimo>();
            
            while(rs.next()){
                u = new Usuario(rs.getInt(2), rs.getString(3));
                u.setId_usuario(rs.getInt(1));
                pu = new Livro(rs.getString(8), rs.getString(9), rs.getInt(10),rs.getInt(11), rs.getInt(13));
                pu.setId_publicacao(rs.getInt(12));
                e = new Emprestimo(u, sdf.format(rs.getDate(5)), sdf.format(rs.getDate(6)), pu);
                if(rs.getInt(7) == 1){
                    e.devolver();
                }
                e.setCodigo(rs.getInt(4));
                lista.add(e);
            }
            
            ps = null;
            rs = null;
            u = null;
            pu = null;
            e = null;
            
            //-----------------------PERIODICO
            
            ps = con.prepareStatement("SELECT U.id_usuario, U.matricula, U.nome, E.id_emprestimo, E.data_emprestimo, E.data_entrega, E.data_devolucao, E.devolvido, P.titulo, P.autor,"
                    + " P.num_total, P.num_disponivel, PER.id_periodico, PER.issn, E.data_devolucao FROM EMPRESTIMO AS E "
                    + " INNER JOIN USUARIO AS U ON (E.ID_USUARIO = U.ID_USUARIO) "
                    + " INNER JOIN PUBLICACAO AS P ON (E.ID_PUBLICACAO = P.ID_PUBLICACAO)"
                    + " INNER JOIN PERIODICO AS PER ON (PER.ID_PERIODICO = P.ID_PUBLICACAO) WHERE E.ID_PUBLICACAO = ? ORDER BY E.DATA_EMPRESTIMO DESC");
            ps.setInt(1, p.getId_publicacao());
            rs = ps.executeQuery();
            
            while(rs.next()){
                u = new Usuario(rs.getInt(2), rs.getString(3));
                u.setId_usuario(rs.getInt(1));
                pu = new Periodico(rs.getString(9), rs.getString(10), rs.getInt(11),rs.getInt(12), rs.getInt(14));
                pu.setId_publicacao(rs.getInt(13));
                e = new Emprestimo(u, sdf.format(rs.getDate(5)), sdf.format(rs.getDate(6)), pu);
                if(rs.getInt(8) == 1){
                    e.devolver();
                }
                e.setCodigo(rs.getInt(4));
                lista.add(e);
            }
            
            
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
            if(rs != null){
                rs.close();
            }
        }
    }
    
    public ArrayList<Emprestimo> consultar(int matricula) throws SQLException{
        ArrayList<Emprestimo> lista = null;
        ResultSet rs = null;
        Emprestimo e = null;
        Usuario u = null;
        Publicacao pu = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT U.id_usuario, U.matricula, U.nome, E.id_emprestimo, E.data_emprestimo, E.data_entrega, E.devolvido, P.titulo, P.autor,"
                    + " P.num_total, P.num_disponivel, L.id_livro, L.isbn, E.data_devolucao FROM EMPRESTIMO AS E "
                    + " INNER JOIN USUARIO AS U ON (E.ID_USUARIO = U.ID_USUARIO) "
                    + " INNER JOIN PUBLICACAO AS P ON (E.ID_PUBLICACAO = P.ID_PUBLICACAO)"
                    + " INNER JOIN LIVRO AS L ON (L.ID_LIVRO = P.ID_PUBLICACAO) WHERE U.MATRICULA = ? ORDER BY E.DATA_EMPRESTIMO DESC");
            ps.setInt(1, matricula);
            rs = ps.executeQuery();
            lista = new ArrayList<Emprestimo>();
            
            while(rs.next()){
                u = new Usuario(rs.getInt(2), rs.getString(3));
                u.setId_usuario(rs.getInt(1));
                pu = new Livro(rs.getString(8), rs.getString(9), rs.getInt(10),rs.getInt(11), rs.getInt(13));
                pu.setId_publicacao(rs.getInt(12));
                e = new Emprestimo(u, sdf.format(rs.getDate(5)), sdf.format(rs.getDate(6)), pu);
                if(rs.getInt(7) == 1){
                    e.devolver();
                }
                e.setCodigo(rs.getInt(4));
                lista.add(e);
            }
            
            ps = null;
            rs = null;
            u = null;
            pu = null;
            e = null;
            
            //-----------------------PERIODICO
            
            ps = con.prepareStatement("SELECT U.id_usuario, U.matricula, U.nome, E.id_emprestimo, E.data_emprestimo, E.data_entrega, E.data_devolucao, E.devolvido, P.titulo, P.autor,"
                    + " P.num_total, P.num_disponivel, PER.id_periodico, PER.issn, E.data_devolucao FROM EMPRESTIMO AS E "
                    + " INNER JOIN USUARIO AS U ON (E.ID_USUARIO = U.ID_USUARIO) "
                    + " INNER JOIN PUBLICACAO AS P ON (E.ID_PUBLICACAO = P.ID_PUBLICACAO)"
                    + " INNER JOIN PERIODICO AS PER ON (PER.ID_PERIODICO = P.ID_PUBLICACAO) WHERE U.MATRICULA = ? ORDER BY E.DATA_EMPRESTIMO DESC");
            ps.setInt(1, matricula);
            rs = ps.executeQuery();
            
            while(rs.next()){
                u = new Usuario(rs.getInt(2), rs.getString(3));
                u.setId_usuario(rs.getInt(1));
                pu = new Periodico(rs.getString(9), rs.getString(10), rs.getInt(11),rs.getInt(12), rs.getInt(14));
                pu.setId_publicacao(rs.getInt(13));
                e = new Emprestimo(u, sdf.format(rs.getDate(5)), sdf.format(rs.getDate(6)), pu);
                if(rs.getInt(8) == 1){
                    e.devolver();
                }
                e.setCodigo(rs.getInt(4));
                lista.add(e);
            }
            
            
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
            if(rs != null){
                rs.close();
            }
        }
    }
    
     
    public boolean devolverEmprestimo(int codigo) throws SQLException{
         try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("UPDATE EMPRESTIMO SET devolvido = ?, data_devolucao = ? WHERE ID_EMPRESTIMO = ?");
            ps.setInt(1, 1);
            ps.setDate(2, getDataAgora());
            ps.setInt(3, codigo);
            ps.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    
    public int total() throws SQLException{
        int total = 0;
        ResultSet rs = null;
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT COUNT(*) FROM EMPRESTIMO");
            rs = ps.executeQuery();
            
            while(rs.next()){
                total = rs.getInt(1);
            }
            return total;
        } catch (SQLException ex) {
            System.out.println(ex);
            return total;
        }finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
            if(rs != null){
                rs.close();
            }
        }
    }
    
    public ArrayList<Publicacao> get10MaisEmprestados() throws SQLException{
        ArrayList<Publicacao> lista = null;
        ResultSet rs = null;
        Publicacao pu = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("select first 10 count(e.ID_PUBLICACAO) id, min(p.titulo) Titulo , min(p.autor) Autor, min(p.num_total) NUM_TOTAL, min(p.num_total) NUM_DISPONIVEL from EMPRESTIMO e" +
            " INNER JOIN PUBLICACAO P ON (P.ID_PUBLICACAO = E.ID_PUBLICACAO)" +
            " GROUP BY e.ID_PUBLICACAO order by 1 desc");
            rs = ps.executeQuery();
            lista = new ArrayList<Publicacao>();
            
            while(rs.next()){
                pu = new Livro(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(1));
                lista.add(pu);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }finally{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
            if(rs != null){
                rs.close();
            }
        }
    }
    
    
    public long getAtrasosDevolucoes() throws SQLException{
        long total = 0;
        
        class DataDevolucao{
            Date dataEntrega;
            Date dataDevolucao;
        }
        
        ArrayList<DataDevolucao> listaDatas = new ArrayList<DataDevolucao>();
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT DATA_ENTREGA, DATA_DEVOLUCAO FROM EMPRESTIMO");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                if(rs.getDate(2) != null){
                    DataDevolucao d = new DataDevolucao();
                    d.dataDevolucao = rs.getDate(2);
                    d.dataEntrega = rs.getDate(1);
                    listaDatas.add(d);
                }
            }
            
            
            int totalEmprestimosVencidos = 0;
            
            if(!listaDatas.isEmpty()){
                for(DataDevolucao l: listaDatas){
                    if(l.dataDevolucao.getTime() > l.dataEntrega.getTime()){
                        total += l.dataDevolucao.getTime() - l.dataEntrega.getTime();
                        totalEmprestimosVencidos++;
                    }
                }
                if(totalEmprestimosVencidos > 0){
                    total = total / totalEmprestimosVencidos;
                }
            }
            return total;
        
        }catch(SQLException ex){
            System.out.println(ex);
            return total;
        }
    }
    
    
    private java.sql.Date getDataAgora() {
	java.util.Date today = new java.util.Date();
	return new java.sql.Date(today.getTime());
    }

     
    
        
}
