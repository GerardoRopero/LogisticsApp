package modelo.dto;

import java.io.Serializable;

public class Perecedero extends Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int diasACaducar;
	private double reduccion;
	
	public double getReduccion() {
		setReduccion();
		return reduccion;
	}

	public void setReduccion() {
		this.reduccion = precioBase - precioFinal;
	}

	public int getDiasACaducar() {
		return diasACaducar;
	}

	public void setDiasACaducar(int diasACaducar) {
		this.diasACaducar = diasACaducar;
	}

	@Override
	public void calcularPrecio() {
		switch (diasACaducar) {
			case 1:
				this.precioFinal = precioBase / 4.0;
				break;
			case 2:
				this.precioFinal = precioBase / 3.0;
				break;
			case 3:
				this.precioFinal = precioBase / 2.0;
				break;
		}
	}

	@Override
	public String getTipo() {
		return "Perecedero";
	}
}
