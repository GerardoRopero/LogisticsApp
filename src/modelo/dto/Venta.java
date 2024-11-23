package modelo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.dao.NoPerecederoDAO;
import modelo.dao.PerecederoDAO;

public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private LocalDate fecha = LocalDate.now();
	private Cliente cliente;
	private ArrayList<DetalleCompra> listaDetalles = new ArrayList<>();
	private PerecederoDAO modeloP;
	private NoPerecederoDAO modeloN;
	private double totalVenta;
	private double aumento;
	private double reduccion;
	
	public double getAumento() {
		setAumento();
		return aumento;
	}

	public void setAumento() {
		if (modeloN == null) {
	        modeloN = new NoPerecederoDAO(); 
	    }
		
		for (DetalleCompra detalle : listaDetalles) {
			NoPerecedero noPerecedero = modeloN.read(detalle.getProducto().getId());
			if (noPerecedero != null) {
				this.aumento += noPerecedero.getAumento() * detalle.getCantidad();
			}
		}
	}

	public double getReduccion() {
		setReduccion();
		return reduccion;
	}

	public void setReduccion() {
		if (modeloP == null) {
	        modeloP = new PerecederoDAO(); 
	    }
		
		for (DetalleCompra detalle : listaDetalles) {
			Perecedero perecedero = modeloP.read(detalle.getProducto().getId());
			if (perecedero != null) {
				this.reduccion += perecedero.getReduccion() * detalle.getCantidad();
			}
		}
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ArrayList<DetalleCompra> getListaDetalles() {
		return listaDetalles;
	}
	
	public void setListaDetalles(ArrayList<DetalleCompra> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}
	
	public double getTotalVenta() {
		return totalVenta;
	}
	
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}
}
