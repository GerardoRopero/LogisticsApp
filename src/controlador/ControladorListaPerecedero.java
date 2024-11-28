package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import modelo.dao.PerecederoDAO;
import modelo.dto.Perecedero;
import vista.VistaListaPerecedero;

public class ControladorListaPerecedero implements ActionListener {
	private VistaListaPerecedero vista;
	private PerecederoDAO modeloP;
	private DefaultTableModel modeloT;
	
	public ControladorListaPerecedero(VistaListaPerecedero vista) {
		this.vista = vista;
		this.modeloP = new PerecederoDAO();
		this.vista.btnConsultarPerecederos.addActionListener(this);
		this.modeloT = (DefaultTableModel) this.vista.tableListaPerecederos.getModel();
		this.vista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vista.btnConsultarPerecederos)) {
			ArrayList<Perecedero> listaPerecedero = modeloP.readAll();
			
			for (Perecedero perecedero : listaPerecedero) {
				Object[] fila = {perecedero.getId(), perecedero.getNombre(), perecedero.getPrecioFinal(), perecedero.getDiasACaducar()};
				modeloT.addRow(fila);
			}
		}
	}
}
