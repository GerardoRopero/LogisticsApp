package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.NoPerecederoDAO;
import modelo.dto.NoPerecedero;
import vista.VistaNoPerecedero;

public class ControladorNoPerecedero implements ActionListener {
	private VistaNoPerecedero vista;
	private NoPerecederoDAO modelo;
	private NoPerecedero noPerecedero;
	
	public ControladorNoPerecedero(VistaNoPerecedero vista) {
		this.vista = vista;
		this.modelo = new NoPerecederoDAO();
		this.vista.btnRegistrar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnModificar.addActionListener(this);
		this.vista.btnLimpiarDatos.addActionListener(this);
		this.vista.setVisible(true);
		
	}
	
	private void limpiarDatos() {
	    vista.textFId.setText("");
	    vista.textFNombre.setText("");
	    vista.textFPrecio.setText("");
	    vista.comboBCalidadProducto.setSelectedItem("1");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vista.btnRegistrar)) {
			noPerecedero = new NoPerecedero();
			noPerecedero.setId(Integer.valueOf(vista.textFId.getText()));
			noPerecedero.setNombre(vista.textFNombre.getText());
			noPerecedero.setPrecioBase(Double.valueOf(vista.textFPrecio.getText()));
			noPerecedero.setCalidadProducto(Integer.valueOf((String) vista.comboBCalidadProducto.getSelectedItem()));
			noPerecedero.calcularPrecio();
			
			if (modelo.create(noPerecedero)) {
				JOptionPane.showMessageDialog(null, "Se adiciona un nuevo no perecedero a los datos.");
			} else {
				JOptionPane.showMessageDialog(null, "YUCA, error al adicionar un nuevo no perecedero.");
			}
			
			limpiarDatos();
		}
		
		if (e.getSource().equals(vista.btnBuscar)) {
			noPerecedero = modelo.read(Integer.valueOf(vista.textFId.getText()));
			limpiarDatos();
			if (noPerecedero == null) {
				JOptionPane.showMessageDialog(null, "YUCA, error, no perecedero no existe.");
			} else {
				vista.textFId.setText(String.valueOf(noPerecedero.getId()));
				vista.textFNombre.setText(noPerecedero.getNombre());
				vista.textFPrecio.setText(String.valueOf(noPerecedero.getPrecioBase()));
				vista.comboBCalidadProducto.setSelectedItem(String.valueOf(noPerecedero.getCalidadProducto()));
			}
		}
		
		if (e.getSource().equals(vista.btnEliminar)) {
			int respuesta = JOptionPane.showConfirmDialog(null, "Estás seguro de borrar?");
			if (respuesta == JOptionPane.YES_OPTION) {
				boolean borrado = modelo.delete(noPerecedero);
				if (borrado) {
					JOptionPane.showMessageDialog(null, "Perecedero borrado de los datos.");
				} else {
					JOptionPane.showMessageDialog(null, "YUCA, error al borrar el perecedero.");
				}
			}
			
			limpiarDatos();
		}
		
		if (e.getSource().equals(vista.btnModificar)) {
			int respuesta = JOptionPane.showConfirmDialog(null, "Estás seguro de modificar?");
			noPerecedero.setId(Integer.valueOf(vista.textFId.getText()));
			noPerecedero.setNombre(vista.textFNombre.getText());
	        noPerecedero.setPrecioBase(Double.valueOf(vista.textFPrecio.getText()));
	        noPerecedero.setCalidadProducto(Integer.valueOf((String) vista.comboBCalidadProducto.getSelectedItem()));
	        noPerecedero.calcularPrecio();
	        int index = modelo.buscarIndex(noPerecedero);
			if (respuesta == JOptionPane.YES_OPTION) {
				modelo.update(index, noPerecedero);
				JOptionPane.showMessageDialog(null, "Los datos del no perecedero fueron modificados");
			}
			
			limpiarDatos();
		}
		
		if (e.getSource().equals(vista.btnLimpiarDatos)) {
			limpiarDatos();
		}
	}
}
