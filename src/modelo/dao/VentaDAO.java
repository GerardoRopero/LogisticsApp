package modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.dto.Venta;

public class VentaDAO {
	private ArrayList<Venta> listaVentas = new ArrayList<>();
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private String archivo;
	
	@SuppressWarnings("unchecked")
	public VentaDAO() {
		this.archivo = "venta";
		File file = new File(archivo);
		if (file.isFile()) {
			try {
				this.entrada = new ObjectInputStream(new FileInputStream(archivo));
				this.listaVentas = (ArrayList<Venta>) entrada.readObject();
				this.entrada.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				this.listaVentas = new ArrayList<>();
				guardar();
			}
		} else {
			this.listaVentas = new ArrayList<>();
		}
	}
	
	public void guardar() {
		try {
			this.salida = new ObjectOutputStream(new FileOutputStream(archivo));
			this.salida.writeObject(listaVentas);
			this.salida.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean create(Venta venta) {
		listaVentas.add(venta);
		guardar();
		return true;
	}
	
	public Venta read(int numeroVenta) {
		if (listaVentas== null) {
			this.listaVentas = new ArrayList<>();
		}
		for (Venta ventaItem : listaVentas) {
			if (ventaItem.getId() == numeroVenta) {
				return ventaItem;
			}
		}
		return null;
	}
	
	public Venta update(int index, Venta venta) {
		listaVentas.set(index, venta);
		guardar();
		return null;
	}
	
	public boolean delete(Venta venta) {
		listaVentas.remove(venta);
		guardar();
		return true;
	}
	
	public int buscarIndex(Venta venta) {
		return listaVentas.indexOf(venta);
	}
	
	public ArrayList<Venta> readAll() {
		return listaVentas;
	}
}
