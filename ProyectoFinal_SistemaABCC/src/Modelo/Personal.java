package Modelo;

public class Personal{
	
	
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
