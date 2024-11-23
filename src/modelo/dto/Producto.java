package modelo.dto;

import java.io.Serializable;

public abstract class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String nombre;
	protected double precioBase;
	protected double precioFinal;
	
	public int getId() {
		return id;
	}
	public void setId(int codigo) {
		this.id = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}
	public double getPrecioFinal() {
		return precioFinal;
	}

	public abstract void calcularPrecio();
	
	public abstract String getTipo();
}

