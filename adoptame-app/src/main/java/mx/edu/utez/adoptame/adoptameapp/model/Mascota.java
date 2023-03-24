package mx.edu.utez.adoptame.adoptameapp.model;

import java.util.Date;

public class Mascota {

	private String nombre;
	private int edad;
	private String descripcion;
	private String tipoMascota;
	private String imagen;
	private boolean disponibleAdopcion;
	private Date fechaRescate;

	private Caracter caracter;

	public Caracter getCaracter() {
		return caracter;
	}

	public void setCaracter(Caracter caracter) {
		this.caracter = caracter;
	}

	public Mascota() {
		super();
	}

	public Mascota(String nombre, int edad, String descripcion, String tipoMascota, String imagen,
			boolean disponibleAdopcion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.tipoMascota = tipoMascota;
		this.imagen = imagen;
		this.disponibleAdopcion = disponibleAdopcion;

	}

	public Mascota(String nombre, int edad, String descripcion, String tipoMascota, String imagen,
			boolean disponibleAdopcion, Date fechaRescate) {
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.tipoMascota = tipoMascota;
		this.imagen = imagen;
		this.disponibleAdopcion = disponibleAdopcion;
		this.fechaRescate = fechaRescate;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoMascota() {
		return tipoMascota;
	}

	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imaen) {
		this.imagen = imaen;
	}

	public boolean isDisponibleAdopcion() {
		return disponibleAdopcion;
	}

	public void setDisponibleAdopcion(boolean disponibleAdopcion) {
		this.disponibleAdopcion = disponibleAdopcion;
	}

	public Date getFechaRescate() {
		return fechaRescate;
	}

	public void setFechaRescate(Date fechaRescate) {
		this.fechaRescate = fechaRescate;
	}
}
