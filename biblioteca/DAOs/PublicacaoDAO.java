/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.DAOs;


import biblioteca.Classes.Conexao;
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
public abstract class PublicacaoDAO {
    protected Connection con = null;
    protected PreparedStatement ps = null;
    
    /**
     *
     * @param p
     * @return
     * @throws java.sql.SQLException
     */
  
    public abstract boolean inserir(Publicacao p) throws SQLException;
   
    public abstract boolean existe(int codigo) throws SQLException;
    
    public boolean alterar(Publicacao p) throws SQLException{
        try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("UPDATE PUBLICACAO SET TITULO = ? , AUTOR = ?, NUM_TOTAL = ? , NUM_DISPONIVEL = ? WHERE ID_PUBLICACAO = ?");
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getAutor());
            ps.setInt(3, p.getQuantidade_Total());
            ps.setInt(4, p.getQuantidadeDisponivel());
            ps.setInt(5, p.getId_publicacao());
            ps.executeUpdate();
            
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
       
    }
    
    /**
     *
     * @param codigo
     * @return
     * @throws SQLException
     */
    public abstract Publicacao consultar(int codigo) throws SQLException;
    
    public boolean deletar(int codigo) throws SQLException{
         try {
            con = Conexao.getConexao();
            ps = con.prepareStatement("DELETE FROM PUBLICACAO WHERE ID_PUBLICACAO = ?");
            ps.setInt(1, codigo);
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
    }
    
    public int total() throws SQLException{
        int total = 0;
        ResultSet rs = null;
        try{
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT NUM_TOTAL FROM PUBLICACAO");
            rs = ps.executeQuery();
            
            while(rs.next()){
                total += rs.getInt(1);
            }

            return total;
        }catch(SQLException e){
            System.err.println(e);
            return total;
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

}
