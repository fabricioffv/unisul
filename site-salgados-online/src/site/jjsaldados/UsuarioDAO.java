package site.jjsaldados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    
    public boolean inserir(Usuario usuario) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {      
        try{
            con = Conexao.getConnection();
            ps = con.prepareStatement("INSERT INTO usuario(nome, email, senha) VALUES (?,?,?)");
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail()); 
            ps.setString(3, usuario.getSenha()); 
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
    
    
    public boolean existeEmail(String email) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException { 
    	ResultSet rs = null;
    	
        try{
            con = Conexao.getConnection();
            ps = con.prepareStatement("SELECT * FROM usuario WHERE email = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            if (rs.next())
            	return true;
            else
            	return false;
            
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
    
    
    public String nomeUsuarioLogin(Usuario usuario) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
    	ResultSet rs = null;
    	String nome = "";
    	
        try{
            con = Conexao.getConnection();
            ps = con.prepareStatement("SELECT nome FROM usuario WHERE email = ? AND senha = ?");
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            rs = ps.executeQuery();
            
            if (rs.next()) 
            	nome = rs.getString(1);
            	
            return nome;
        }catch(SQLException e){
        	System.err.println(e);
        	return "";
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
    
   
   /* public Usuario consultar(int matricula) throws SQLException{
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

         
    }*/
}
