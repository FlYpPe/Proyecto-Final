package Controlador;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.Joinable;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

import ConexionBaseDeDatos.*;
import Modelo.ModeloAyunta;

public class Controlador {

	public boolean agregarRegistro(String tabla, String values) {

		String sql = "insert into " + tabla + " " + values;
		System.out.println(sql);
		return new ConexionBD().ejInstr(sql);

	}

	public boolean revisar(String Tabla, String sq) {

		String sql = "SELECT * FROM " + Tabla +" WHERE " + sq;
		ResultSet res = new ConexionBD().ejecutarConsulta(sql);
		System.out.println(sql);
		
		try {
			res.last();
			
			String a = res.getString(1);/*
			if (Tabla.equals("Ayuntamiento")) {
				String a = res.getString("Encargado");
			}
			if (Tabla.equals("Personal")) {
				
			}
			if (Tabla.equals("SistemaRecoleccion")) {
				
			}
			*/
			
			return true;
		} catch (Exception e) {
			// TODO: handle exceptionreturn false;
		}
		return false;
		
		

	}
	
	
	
	
	
	
	public boolean revisar(String tabla, String pasw,String usuario) {
		
		consulta c1 = new consulta(tabla);
		
		Thread t1 = new Thread(c1);
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs = c1.rs;
				
		try {
			while (rs.next()) {
				if (rs.getString(1).equals(pasw) && rs.getString(2).equals(usuario)) {
					return true;
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
		
	}

	
	public void actualizar(String tabla, String sq) {
		
		String sql = "Update " + tabla + " Set " + sq; 
		System.out.println(sql);
		new ConexionBD().ejInstr(sql);
		
		
		
		//Update ayuntamiento set Departamento = 'actu',Estado = 'actu', CantPersonal = 77, Encargado = 'actu' where encargado = 'asd';
	}
	
	public boolean eliminarRegistro(String tabla, String sq) {
		
		String sql = "Delete From " + tabla + " Where " + sq;
		boolean res = new ConexionBD().ejInstr(sql);
		return res;
		
	}
	
	
	public JTable retornarTabla(String inst) {
		consulta c1 = new consulta(inst);
		HiloTabla ht1 = new HiloTabla(c1);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(ht1);
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CrearTabla modelo = new CrearTabla(new ConexionBD().ejecutarConsulta("SELECT * FROM " + inst));

		return ht1.retornarTabla();

	}

}



class consulta implements Runnable {

	boolean valido;
	ResultSet rs;
	String sql;
	
	public consulta(String ntabla) {

		this.sql = ntabla;
		
	}
	
	@Override
	public void run() {
		rs = new ConexionBD().ejecutarConsulta("SELECT * FROM " + sql);
	}

}

class HiloTabla implements Runnable{
	
	JTable table;
	consulta c;
	ResultSet rs;
	
	public HiloTabla(consulta c) {
		this.c = c;
		
	}
	
	@Override
	public void run() {

		rs = c.rs;
		
		CrearTabla tabla = new CrearTabla(rs);
		table = new JTable(tabla);
	}
	
	public JTable retornarTabla() {
		
		
		return table;
		
	}
	
}

class CrearTabla extends AbstractTableModel {

	private ResultSet rsRegistros;
	private ResultSetMetaData metaData;

	public CrearTabla(ResultSet unResultSet) {

		this.rsRegistros = unResultSet;
		try {
			
			this.metaData = this.rsRegistros.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getColumnCount() {

		try {
			return metaData.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int getRowCount() {

		try {
			rsRegistros.last();
			return rsRegistros.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public Object getValueAt(int arg0, int arg1) {

		try {
			rsRegistros.absolute(arg0 + 1);
			return rsRegistros.getObject(arg1 + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String getColumnName(int c) {

		try {
			return metaData.getColumnName(c + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
