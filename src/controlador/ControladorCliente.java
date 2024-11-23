package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.dao.ClienteDAO;
import modelo.dto.Cliente;
import vista.VistaCliente;

public class ControladorCliente implements ActionListener {
	private VistaCliente vista;
	private ClienteDAO modelo;
	private Cliente cliente;
	
	public ControladorCliente(VistaCliente vista) {
		this.vista = vista;
		this.modelo = new ClienteDAO();
		this.vista.btnRegistrar.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.btnLimpiarDatos.addActionListener(this);
		this.vista.setVisible(true);
	}
	
	public void limpiarDatos() {
		vista.textFId.setText("");
		vista.textFNombre.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vista.btnRegistrar)) {
			cliente = new Cliente();
			cliente.setId(Integer.valueOf(vista.textFId.getText()));
			cliente.setNombre(vista.textFNombre.getText());
			
			if (modelo.create(cliente)) {
				JOptionPane.showMessageDialog(null, "Se adiciona un nuevo cliente a los datos.");
			} else {
				JOptionPane.showMessageDialog(null, "YUCA, error al adicionar un nuevo cliente.");
			}
			
			limpiarDatos();
		}
		
		if (e.getSource().equals(vista.btnBuscar)) {
			cliente = modelo.read(Integer.valueOf(vista.textFId.getText()));
			limpiarDatos();
			if (cliente == null) {
				JOptionPane.showMessageDialog(null, "YUCA, error, cliente no existe.");
			} else {
				vista.textFId.setText(String.valueOf(cliente.getId()));
				vista.textFNombre.setText(String.valueOf(cliente.getNombre()));
			}
		}
		
		if (e.getSource().equals(vista.btnEliminar)) {
			int respuesta = JOptionPane.showConfirmDialog(null, "Estás seguro de borrar?");
			if (respuesta == JOptionPane.YES_OPTION) {
				boolean borrado = modelo.delete(cliente);
				if (borrado) {
					JOptionPane.showMessageDialog(null, "Cliente borrado de los datos.");
				} else {
					JOptionPane.showMessageDialog(null, "YUCA, error al borrar el cliente.");
				}
			}
			
			limpiarDatos();
		}
		
		if (e.getSource().equals(vista.btnModificar)) {
			int respuesta = JOptionPane.showConfirmDialog(null, "Estás seguro de modificar?");
			if (respuesta == JOptionPane.YES_OPTION) {
				int index = modelo.buscarIndex(cliente);
				modelo.update(index, cliente);
				JOptionPane.showMessageDialog(null, "Los datos del cliente fueron modificados.");
			}
			
			limpiarDatos();
		}
		
		if (e.getSource().equals(vista.btnLimpiarDatos)) {
			limpiarDatos();
		}
	}
	
}