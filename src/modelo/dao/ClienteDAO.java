package modelo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.dto.Cliente;

public class ClienteDAO {
	private ArrayList<Cliente> listaClientes = new ArrayList<>();
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private String archivo;
	
	@SuppressWarnings("unchecked")
	public ClienteDAO() {
		this.archivo = "cliente";
		File file = new File(archivo);
		if (file.isFile()) {
			try {
				this.entrada = new ObjectInputStream(new FileInputStream(archivo));
				this.listaClientes = (ArrayList<Cliente>) entrada.readObject();
				this.entrada.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				this.listaClientes = new ArrayList<>();
				guardar();
			}
		} else {
			this.listaClientes = new ArrayList<>();
		}
	}
	
	public void guardar() {
		try {
			this.salida = new ObjectOutputStream(new FileOutputStream(archivo));
			this.salida.writeObject(listaClientes);
			this.salida.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean create(Cliente cliente) {
		if (listaClientes == null) {
			this.listaClientes = new ArrayList<>();
		}
		listaClientes.add(cliente);
		guardar();
		return true;
	}
	
	public Cliente read(int id) {
		if (listaClientes == null) {
			this.listaClientes= new ArrayList<>();
		}
		for (Cliente clientei : listaClientes) {
			if (clientei.getId() == id) {
				return clientei;
			}
		}
		return null;
	}
	
	public Cliente update(int index, Cliente cliente) {
		listaClientes.set(index, cliente);
		guardar();
		return null;
	}
	
	public boolean delete(Cliente cliente) {
		listaClientes.remove(cliente);
		guardar();
		return true;
	}
	
	public int buscarIndex(Cliente cliente) {
		return listaClientes.indexOf(cliente);
	}
	
	public ArrayList<Cliente> readAll() {
		return listaClientes;
	}
}

