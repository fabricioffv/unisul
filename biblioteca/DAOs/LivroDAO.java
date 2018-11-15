/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.DAOs;

import biblioteca.Classes.Conexao;
import biblioteca.DAOs.PublicacaoDAO;
import biblioteca.Classes.Livro;
import biblioteca.Classes.Publicacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabricio
 */
public class LivroDAO extends PublicacaoDAO {
    @Override
    public boolean inserir(Publicacao l) throws SQLException{
        if (!existe(l.getCodigo())) {
            try {
                //Primeiro vai inserir na tabela publicacao
                con = Conexao.getConexao();
                ps = con.prepareStatement("INSERT INTO PUBLICACAO(id_publicacao, titulo, autor, num_total, num_disponivel) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, 0);
                ps.setString(2, l.getTitulo());
                ps.setString(3, l.getAutor());
                ps.setInt(4, l.getQuantidade_Total());
                ps.setInt(5, l.getQuantidade_Total());
                ps.execute();
                
                //Pega o ultimo ID gerado para inserir na tabela de livros
                ResultSet rs = ps.getGeneratedKeys();
                int lastID = -1;
                if(rs.next()){
                    lastID = rs.getInt(1);
                }
                
                ps = con.prepareStatement("INSERT INTO LIVRO(ID_LIVRO, ISBN) VALUES (?,?)");
                ps.setInt(1, lastID);
                ps.setInt(2, l.getCodigo());
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

    /**
     *
     * @param codigo
     * @return
     * @throws SQLException
     */
    @Override
    public boolean existe(int codigo) throws SQLException {
        ResultSet rs = null;
        try{
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT isbn FROM LIVRO WHERE isbn = ?");
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
    
    @Override
    public Livro consultar(int codigo) throws SQLException{
        ResultSet rs = null;
        Livro l = null;
        
        if(existe(codigo)){
            try{
                con = Conexao.getConexao();
                ps = con.prepareStatement("SELECT titulo, autor, num_total, num_disponivel, isbn, id_livro "
                        + "FROM PUBLICACAO INNER JOIN LIVRO ON PUBLICACAO.ID_PUBLICACAO = LIVRO.ID_LIVRO WHERE isbn = ?");
                ps.setInt(1, codigo);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    l = new Livro(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                    l.setId_publicacao(rs.getInt(6));
                }
                
                return l;                
            }catch(SQLException ex){
                System.err.println(ex);
                return null;
            }
        }else{
            return l;
        }
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<Livro> consultar() throws SQLException{
        ResultSet rs = null;
        ArrayList<Livro> lista = new ArrayList<Livro>();
        Livro l = null;
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT titulo, autor, num_total, num_disponivel, isbn, id_livro "
                    + "FROM PUBLICACAO INNER JOIN LIVRO ON PUBLICACAO.ID_PUBLICACAO = LIVRO.ID_LIVRO ORDER BY TITULO ASC");
            rs = ps.executeQuery();

            while (rs.next()) {
                l = new Livro(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                l.setId_publicacao(rs.getInt(6));
                lista.add(l);
            }
            return lista;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }
    

}
