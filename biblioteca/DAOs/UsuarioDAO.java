/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.DAOs;

import biblioteca.Classes.Conexao;
import biblioteca.Classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fabricio
 */
public class UsuarioDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    
    public boolean inserir(Usuario usuario) throws SQLException{      
        try{
            con = Conexao.getConexao();
            ps = con.prepareStatement("INSERT INTO USUARIO(id_usuario, matricula, nome) VALUES (?,?,?)");
            ps.setInt(1, 0);
            ps.setInt(2, usuario.getMatricula());
            ps.setString(3, usuario.getNome()); 
            ps.execute();
            
            return true;
        }catch(SQLException e){
          System.err.println(e);
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
    
    public int existe(int matricula) throws SQLException{
        ResultSet rs = null;
        int numLinhas = 0;
        
        try{
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT matricula FROM USUARIO WHERE matricula = ?");
            ps.setInt(1, matricula);
            rs = ps.executeQuery();
            
            while(rs.next()){
                numLinhas++;
            }
            return numLinhas;
            
        }catch(SQLException e){
            System.err.println(e);
            return numLinhas;
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
    
    public Usuario consultar(int matricula) throws SQLException{
        Usuario u = null;
        ResultSet rs = null;
        
        if(existe(matricula) == 1){
            try{
                con = Conexao.getConexao();
                ps = con.prepareStatement("SELECT id_usuario,matricula,nome FROM USUARIO WHERE matricula = ?");
                ps.setInt(1, matricula);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    u = new Usuario(rs.getInt(2), rs.getString(3));
                    u.setId_usuario(rs.getInt(1));
                }
                
                return u;
            }catch(SQLException e){
                System.err.println(e);
                return null;
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
        }else{
            return null;
        }
         
    }
    
    public boolean alterar(Usuario u) throws SQLException{
        try{
            con = Conexao.getConexao();
            ps = con.prepareStatement("UPDATE USUARIO SET NOME = ? WHERE MATRICULA = ?");
            ps.setString(1, u.getNome());
            ps.setInt(2, u.getMatricula());
            ps.executeUpdate();
            
            return true;
        }catch(SQLException e){
          System.err.println(e);
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
    
    public boolean deletar(Usuario u) throws SQLException{
        try{
            con = Conexao.getConexao();
            ps = con.prepareStatement("DELETE FROM USUARIO WHERE MATRICULA = ?");
            ps.setInt(1, u.getMatricula());
            ps.executeUpdate();
            
            return true;
        }catch(SQLException e){
          System.err.println(e);
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
        try{
            con = Conexao.getConexao();
            ps = con.prepareStatement("SELECT COUNT(*) FROM USUARIO");
            rs = ps.executeQuery();
            
            while(rs.next()){
                total = rs.getInt(1);
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
