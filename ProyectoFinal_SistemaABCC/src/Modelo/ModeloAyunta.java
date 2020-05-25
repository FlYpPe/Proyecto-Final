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

class Personal{
	
	
	String nombre;
	String area;
	int sueldo;
	int horasDiarias;
	
	public Personal(String nombre, String area, int sueldo, int horasDiarias) {
		super();
		this.nombre = nombre;
		this.area = area;
		this.sueldo = sueldo;
		this.horasDiarias = horasDiarias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int getHorasDiarias() {
		return horasDiarias;
	}

	public void setHorasDiarias(int horasDiarias) {
		this.horasDiarias = horasDiarias;
	}
	
	
	
}

class SistemaRecoleccion{
	
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