package modelo.dto;

import java.io.Serializable;

public class NoPerecedero extends Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int calidadProducto;
	private double aumento;

	public double getAumento() {
		setAumento();
		return aumento;
	}

	public void setAumento() {
		this.aumento = precioFinal - precioBase;
	}

	public int getCalidadProducto() {
		return calidadProducto;
	}

	public void setCalidadProducto(int calidadProducto) {
		this.calidadProducto = calidadProducto;
		verificarTipo();
	}

	@Override
	public void calcularPrecio() {
		switch (calidadProducto) {
			case 1: 
				this.precioFinal = (double) Math.round((precioBase + precioBase * (3.0 / 100)) * 100) / 100.0;
				break;
			case 2:
				this.precioFinal = (double) Math.round((precioBase + precioBase * (2.0 / 100)) * 100) / 100.0;
				break;
			case 3:
				this.precioFinal = (double) Math.round((precioBase + precioBase * (1.0 / 100)) * 100) / 100.0;
				break;
		}
	}

	@Override
	public String getTipo() {
		return "No Perecedero";
	}

	
	private void verificarTipo() {
		if (this.calidadProducto < 1 || this.calidadProducto > 3) {
			this.calidadProducto = 1;
		}
	}
}
