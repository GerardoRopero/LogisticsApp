package modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.dto.Perecedero;

public class PerecederoDAO {
	private ArrayList<Perecedero> listaPerecederos;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private String archivo;
	
	@SuppressWarnings("unchecked")
	public PerecederoDAO() {
		this.archivo = "perecedero";
		File file = new File(archivo);
		if (file.isFile()) {
			try {
				this.entrada = new ObjectInputStream(new FileInputStream(archivo));
				this.listaPerecederos = (ArrayList<Perecedero>) entrada.readObject();
				this.entrada.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				guardar();
			}
		} else {
			listaPerecederos = new ArrayList<>();
		}
	}
	
	public void guardar() {
		try {
			this.salida = new ObjectOutputStream(new FileOutputStream(archivo));
			this.salida.writeObject(listaPerecederos);
			this.salida.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean create(Perecedero perecedero) {
	    listaPerecederos.add(perecedero);
	    guardar();
	    return true;
	}

	public Perecedero read(int codigo) {
	    for (Perecedero perecedero : listaPerecederos) {
	        if (perecedero.getId() == codigo) {
	            return perecedero;
	        }
	    }
	    return null;
	}


	public void update(int index, Perecedero perecedero) {
		listaPerecederos.set(index, perecedero);
		guardar();
	}

	public boolean delete(Perecedero perecedero) {
		listaPerecederos.remove(perecedero);
		guardar();
		return true;
	}

	public int buscarIndex(Perecedero perecedero) {
		return listaPerecederos.indexOf(perecedero);
	}

	public ArrayList<Perecedero> readAll() {
		return listaPerecederos;
	}
	
	public void reiniciarDatosPerecedero() {
	    listaPerecederos.clear(); 
	    guardar();  
	}
}
