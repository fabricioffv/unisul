/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fabricio
 */
public class Conexao {
    private static String caminhoBanco = "jdbc:firebirdsql:localhost/3050:C:/Users/Fabricio/Desktop/NetBeans/Banco.fdb";
    private static String user = "SYSDBA";
    private static String pass = "masterkey";
            
    public static Connection getConexao(){
            Connection conn = null;
            try{
                Class.forName("org.firebirdsql.jdbc.FBDriver");
                conn = DriverManager.getConnection(caminhoBanco, user, pass);
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e);
            } 
            return conn;
    }
	
}
