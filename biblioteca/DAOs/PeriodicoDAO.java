/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.DAOs;

import biblioteca.Classes.Conexao;
import biblioteca.Classes.Periodico;
import biblioteca.Classes.Publicacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fabricio
 */
public class PeriodicoDAO extends PublicacaoDAO {   
    
    @Override
    public boolean inserir(Publicacao p) throws SQLException{      
        if (!existe(p.getCodigo())) {
            try {
                con = Conexao.getConexao();
                ps = con.prepareStatement("INSERT INTO PUBLICACAO(id_publicacao, titulo, autor, num_total, num_disponivel) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, 0);
                ps.setString(2, p.getTitulo());
                ps.setString(3, p.getAutor());
                ps.setInt(4, p.getQuantidade_Total());
                ps.setInt(5, p.getQuantidade_Total());
                ps.execute();

                //Pega o ultimo ID gerado para inserir na tabela de livros
                ResultSet rs = ps.getGeneratedKeys();
                int lastID = -1;
                if(rs.next()){
                    lastID = rs.getInt(1);
                }
                
                ps = con.prepareStatement("INSERT INTO PERIODICO(ID_PERIODICO, ISSN) VALUES (?,?)");
                ps.setInt(1, lastID);
                ps.setInt(2, p.getCodigo());
                ps.execute();
  
                return true;
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            } finally {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean existe(int codigo) throws SQLException {
        ResultSet rs = null;
        
        try{
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT issn FROM PERIODICO WHERE issn = ?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
        
    
    public Periodico consultar(int codigo) throws SQLException{
        ResultSet rs = null;
        Periodico p = null;
        
        if(existe(codigo)){
            try{
                con = Conexao.getConexao();
                ps = con.prepareStatement("SELECT titulo, autor, num_total, num_disponivel, issn, id_periodico FROM PUBLICACAO "
                        + "INNER JOIN PERIODICO ON PUBLICACAO.ID_PUBLICACAO = PERIODICO.ID_PERIODICO WHERE issn = ?");
                ps.setInt(1, codigo);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    p = new Periodico(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                    p.setId_publicacao(rs.getInt(6));
                }
                
                return p;                
            }catch(SQLException ex){
                System.err.println(ex);
                return null;
            }
        }else{
            return p;
        }
    }
    
    public ArrayList<Periodico> consultar() throws SQLException{
        ResultSet rs = null;
        ArrayList<Periodico> lista = new ArrayList<Periodico>();
        Periodico p = null;
        
        try{
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT titulo, autor, num_total, num_disponivel, issn, id_periodico FROM PUBLICACAO "
                    + "INNER JOIN PERIODICO ON PUBLICACAO.ID_PUBLICACAO = PERIODICO.ID_PERIODICO ORDER BY TITULO ASC");
            rs = ps.executeQuery();

            while(rs.next()){
                p = new Periodico(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                p.setId_publicacao(rs.getInt(6));
                lista.add(p);
            }

            return lista;        
        }catch(SQLException ex){
            System.err.println(ex);
            return null;
        }
    }
}
