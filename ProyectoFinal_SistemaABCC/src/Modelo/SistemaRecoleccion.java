package Modelo;

public class SistemaRecoleccion{
	
	String estrategia;
	int vehiculos;
	int cantidadEmpleados;
	String estado;
	public SistemaRecoleccion(String estrategia, int vehiculos, int cantidadEmpleados, String estado) {
		super();
		this.estrategia = estrategia;
		this.vehiculos = vehiculos;
		this.cantidadEmpleados = cantidadEmpleados;
		this.estado = estado;
	}
	public String getEstrategia() {
		return estrategia;
	}
	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}
	public int getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(int vehiculos) {
		this.vehiculos = vehiculos;
	}
	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}
	public void setCantidadEmpleados(int cantidadEmpleados) {
		this.cantidadEmpleados = cantidadEmpleados;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
