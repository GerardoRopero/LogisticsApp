package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.dao.PerecederoDAO;
import modelo.dto.Perecedero;
import vista.VistaPerecedero;

public class ControladorPerecedero implements ActionListener {
	private VistaPerecedero vista;
	private PerecederoDAO modelo;
	private Perecedero perecedero;
	
	public ControladorPerecedero(VistaPerecedero vista) {
		this.vista = vista;
		this.modelo = new PerecederoDAO();
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
	    vista.comboBDiasACaducar.setSelectedItem("1");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vista.btnRegistrar)) {
			perecedero = new Perecedero();
			perecedero.setId(Integer.valueOf(vista.textFId.getText()));
			perecedero.setNombre(vista.textFNombre.getText());
			perecedero.setPrecioBase(Double.valueOf(vista.textFPrecio.getText()));
			perecedero.setDiasACaducar(Integer.valueOf((String) vista.comboBDiasACaducar.getSelectedItem()));
			perecedero.calcularPrecio();
			
			if (modelo.create(perecedero)) {
				JOptionPane.showMessageDialog(null, "Se adiciona un nuevo perecedero a los datos.");
			} else {
				JOptionPane.showMessageDialog(null, "YUCA, error al adicionar un nuevo perecedero.");
			}
			
			limpiarDatos();
			
		}
		

		if (e.getSource().equals(vista.btnBuscar)) {
			perecedero = modelo.read(Integer.valueOf(vista.textFId.getText()));
			limpiarDatos();
			if (perecedero == null) {
				JOptionPane.showMessageDialog(null, "YUCA, error, perecedero no existe.");
			} else {
				vista.textFId.setText(String.valueOf(perecedero.getId()));
				vista.textFNombre.setText(perecedero.getNombre());
				vista.textFPrecio.setText(String.valueOf(perecedero.getPrecioBase()));
				vista.comboBDiasACaducar.setSelectedItem(String.valueOf(perecedero.getDiasACaducar()));
			}
		}
		
		if (e.getSource().equals(vista.btnEliminar)) {
			int respuesta = JOptionPane.showConfirmDialog(null, "Estás seguro de borrar?");
			if (respuesta == JOptionPane.YES_OPTION) {
				boolean borrado = modelo.delete(perecedero);
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
			perecedero.setNombre(vista.textFNombre.getText());
	        perecedero.setPrecioBase(Double.valueOf(vista.textFPrecio.getText()));
	        perecedero.setDiasACaducar(Integer.valueOf((String) vista.comboBDiasACaducar.getSelectedItem()));
			int index = modelo.buscarIndex(perecedero);
			if (respuesta == JOptionPane.YES_OPTION) {
				modelo.update(index, perecedero);
				JOptionPane.showMessageDialog(null, "Los datos del perecedero fueron modificados");
			}
			
			limpiarDatos();
		}
		
		if (e.getSource().equals(vista.btnLimpiarDatos)) {
			limpiarDatos();
		}
	}
}

