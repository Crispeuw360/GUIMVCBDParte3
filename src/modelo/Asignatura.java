package modelo;

public class Asignatura {

	private String id;
	private String nombre;
	private int creditos;
	private String dni;
	public Asignatura(String id, String nombre, int creditos, String dni) 
	{
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
		this.dni = dni;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", creditos=" + creditos + ", dni=" + dni + "]";
	}
	
	
	
}
