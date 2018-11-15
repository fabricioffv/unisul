package site.jjsaldados;
import java.sql.*;

public class Conexao {
	static String status = "";
	static String url = "jdbc:mysql://localhost:3306/sitejj"; 
	static String usuario = "root"; 
	static String senha = "M@st3r";
	static String driver = "com.mysql.jdbc.Driver";
	
	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
		}
		catch(SQLException e){
			status = e.getMessage();
		}
		
		return conn;
	}
}
