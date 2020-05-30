package Controlador;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import ConexionBaseDeDatos.*;
import Modelo.ModeloAyunta;

public class Controlador {

	public boolean agregarRegistro(String tabla, String values) {

		String sql = "insert into " + tabla + " " + values;
		System.out.println(sql);
		return new ConexionBD().ejInstr(sql);

	}

	public boolean revisar(String Tabla, String dato) {

		String sql = "SELECT * FROM Ayuntamiento WHERE Encargado = 'asd'";

		ResultSet res = new ConexionBD().ejecutarConsulta(sql);

		
		try {
			res.last();
			String a = res.getString("Encargado");
			return true;
		} catch (Exception e) {
			// TODO: handle exceptionreturn false;
		}
		return false;
		
		

	}
	
	public void actualizar(ModeloAyunta a) {
		String sql = "Update Ayuntamiento Set Departamento = '" + a.getDepartamento() + "', Estado = '" + a.getEstado() + "' , CantPersonal = " + a.getCantidadPersonal() + ", Encargado = '" + a.getDepartamento()+ "' where encargado = '" + a.getEncargado() + "'";
		System.out.println(sql);
		new ConexionBD().ejInstr(sql);
		
		//Update ayuntamiento set Departamento = 'actu',Estado = 'actu', CantPersonal = 77, Encargado = 'actu' where encargado = 'asd';
	}
/*
	public boolean modificarAlumno(Alumno a) {
		  
		
		
		  String sql = "Update Alumnos Set Nombre_Alumno= '" + a.getNombre() + "'" +
		  ", Primer_Ap_Alumno = '" + a.getPrimerAp() + "'" + ", Segundo_Ap_Alumno = '"
		  + a.getSegundoAp() + "'" + ", Edad_Alumno = " + a.getEdad() + "" +
		  ", Semestre = " + a.getSemestre() + "" + ", Carrera = '" + a.getCarrera() +
		  "' WHERE Num_Control='" + a.getNumControl() + "'";
		  
		  // Nombre_Alumno | Primer_Ap_Alumno | Segundo_Ap_Alumno | Edad_Alumno |
		  Semestre | Carrera
		  
		  boolean res = new ConexionBD().ejInstr(sql); return res;
		  
		  }
	
	
	
	/*
	 * 
	 * public Alumno buscarAlumno(String numControl) {
	 * 
	 * String sql = "SELECT * FROM Alumnos WHERE Num_Control = '" + numControl +
	 * "'";
	 * 
	 * ResultSet res = new ConexionBD().ejecutarConsulta(sql);
	 * 
	 * try { res.last();
	 * 
	 * return new Alumno(res.getString("Num_Control"), res.getString(2),
	 * res.getString(3), res.getString(4), res.getByte(5), res.getByte(5),
	 * res.getString(6));
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * 
	 * return null; }
	 * 
	 * }
	 * 
	 * 
	 * /* public boolean agregarAlumno(Alumno a) { String sql =
	 * "insert into Alumnos Values('" + a.getNumControl() + "','" + a.getPrimerAp()
	 * + "','" + a.getNombre() + "','" + a.getSegundoAp() + "'," + a.getEdad() + ","
	 * + a.getSemestre() + ",'" + a.getCarrera() + "')";
	 * 
	 * return new ConexionBD().ejInstr(sql);
	 * 
	 * }
	 * 
	 * public boolean eliminarAlumno(String numControl) {
	 * 
	 * String sql = "Delete From alumnos where num_control = '" + numControl + "'";
	 * boolean res = new ConexionBD().ejInstr(sql);
	 * 
	 * return false;
	 * 
	 * }cmd
	 *
	 * 
	 * public boolean modificarAlumno(Alumno a) {
	 * 
	 * String sql = "Update Alumnos Set Nombre_Alumno= '" + a.getNombre() + "'" +
	 * ", Primer_Ap_Alumno = '" + a.getPrimerAp() + "'" + ", Segundo_Ap_Alumno = '"
	 * + a.getSegundoAp() + "'" + ", Edad_Alumno = " + a.getEdad() + "" +
	 * ", Semestre = " + a.getSemestre() + "" + ", Carrera = '" + a.getCarrera() +
	 * "' WHERE Num_Control='" + a.getNumControl() + "'";
	 * 
	 * // Nombre_Alumno | Primer_Ap_Alumno | Segundo_Ap_Alumno | Edad_Alumno |
	 * Semestre | Carrera
	 * 
	 * boolean res = new ConexionBD().ejInstr(sql); return res;
	 * 
	 * }
	 * 
	 * public Alumno buscarAlumno(String numControl) {
	 * 
	 * String sql = "SELECT * FROM Alumnos WHERE Num_Control = '" + numControl +
	 * "'";
	 * 
	 * ResultSet res = new ConexionBD().ejecutarConsulta(sql);
	 * 
	 * try { res.last();
	 * 
	 * return new Alumno(res.getString("Num_Control"), res.getString(2),
	 * res.getString(3), res.getString(4), res.getByte(5), res.getByte(5),
	 * res.getString(6));
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * 
	 * return null; }
	 * 
	 * }
	 */
	public JTable retornarTabla(String nTabla) {

		CrearTabla modelo = new CrearTabla(new ConexionBD().ejecutarConsulta("SELECT * FROM " + nTabla));

		return new JTable(modelo);

	}

}

class consulta implements Runnable {

	@Override
	public void run() {

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
