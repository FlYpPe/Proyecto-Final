package ConexionBaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

	private Connection con;
	//private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	public ConexionBD() {
		//verifica que exista el conector entre java y mysql
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");	
			
			String URL = "jdbc:mysql://localhost:3306/proyecto";
			String url = "jdbc:mysql://localhost:3306/proyecto?useTimezone=true&serverTimezone=UTC";
			con = DriverManager.getConnection(url, "root", "felip");
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error del Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error en conexion a Mysql	");
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		
		new ConexionBD();

	}
	
	public boolean ejInstr(String sql) {
		
		try {
			
		pstm = con.prepareStatement(sql);
		//stm = con.createStatement();
		int r = pstm.executeUpdate(sql);
			return r == 1 ? true : false ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public ResultSet ejecutarConsulta(String sql) {
		
		ResultSet es = null;
		
		
		try {
			pstm = con.prepareStatement(sql);
		//stm = con.createStatement();
		
		return pstm.executeQuery(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return rs;
		}
		
		
		
		
		
	}
	
	
public void cerrarConeccion() {
	try {
		
		pstm.close();
		//stm.close();
		con.close();
	}catch (Exception e) {
		// TODO: handle exception
	}
}
}