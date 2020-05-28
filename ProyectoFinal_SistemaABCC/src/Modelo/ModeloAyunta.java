package Modelo;

public class ModeloAyunta {

	String departamento;
	String estado;
	int cantidadPersonal;
	String encargado;
	public ModeloAyunta(String departamento, String estado, int cantidadPersonal, String encargado) {
		
		this.departamento = departamento;
		this.estado = estado;
		this.cantidadPersonal = cantidadPersonal;
		this.encargado = encargado;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCantidadPersonal() {
		return cantidadPersonal;
	}
	public void setCantidadPersonal(int cantidadPersonal) {
		this.cantidadPersonal = cantidadPersonal;
	}
	public String getEncargado() {
		return encargado;
	}
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	
	
	
}



