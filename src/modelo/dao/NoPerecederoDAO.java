package modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.dto.NoPerecedero;

public class NoPerecederoDAO {
	private ArrayList<NoPerecedero> listaNoPerecederos;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private String archivo;
	
	@SuppressWarnings("unchecked")
	public NoPerecederoDAO() {
		this.archivo = "noperecedero";
		File file = new File(archivo);
		if (file.isFile()) {
			try {
				this.entrada = new ObjectInputStream(new FileInputStream(archivo));
				this.listaNoPerecederos = (ArrayList<NoPerecedero>) entrada.readObject();
				this.entrada.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				guardar();
			}
		} else {
			listaNoPerecederos = new ArrayList<>();
		}
	}
	
	public void guardar() {
		try {
			this.salida = new ObjectOutputStream(new FileOutputStream(archivo));
			this.salida.writeObject(listaNoPerecederos);
			this.salida.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean create(NoPerecedero noPerecedero) {
		if (listaNoPerecederos == null) {
			this.listaNoPerecederos = new ArrayList<>();
		}
		listaNoPerecederos.add(noPerecedero);
		guardar();
		return true;
	}
	
	public NoPerecedero read(int codigo) {
		for (NoPerecedero noPerecedero : listaNoPerecederos) {
			if (noPerecedero.getId() == codigo) {
				return noPerecedero;
			}
		}
		return null;
	}
	
	public NoPerecedero update(int index, NoPerecedero noPerecedero) {
		listaNoPerecederos.set(index, noPerecedero);
		guardar();
		return null;
	}
	
	public boolean delete(NoPerecedero noPerecedero) {
		listaNoPerecederos.remove(noPerecedero);
		guardar();
		return true;
	}
	
	public int buscarIndex(NoPerecedero noPerecedero) {
		return listaNoPerecederos.indexOf(noPerecedero);
	}
	
	public ArrayList<NoPerecedero> readAll() {
		return listaNoPerecederos;
	}
	
	public void reiniciarDatos() {
	    listaNoPerecederos.clear();
	    guardar(); 
	}
}


